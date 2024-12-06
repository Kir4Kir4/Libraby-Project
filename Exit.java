package Library;

import java.util.Scanner;

public class Exit implements Operation {

    Scanner s;
    Database database;
    User user;

    @Override
    public void oper(Database database, User user) {
        this.database = database;
        this.user = user;

        System.out.println("\n Are you sure that you want to quit?\n"
                + "1. Yes\n2. Main Menu");
        s = new Scanner(System.in);
        int i = s.nextInt();
        if (i == 1) {
            System.out.println("0.Exit\n" + "1.Login\n2. New User");
            s = new Scanner(System.in);
            int num = s.nextInt();

            switch (num) {
                case 1:
                    login();
                    break;
                case 2:
                    newUser();
                    break;
            }
        } else {
            user.menu(database, user);
        }

    }

    private  void login() {
        System.out.println("Enter student ID:");
        String student_ID = s.next();
        System.out.println("Enter name:");
        String name = s.next();
        int n = database.login(student_ID, name);
        if (n != -1) {
            User user = database.getUser(n);
            user.menu(database, user);
        } else {
            System.out.println(" User doesn't exist!");
        }
    }

    private void newUser() {
        System.out.println("Enter name:");
        String name = s.next();
        System.out.println("Enter student ID:");
        String student_ID = s.next();
        System.out.println("1. Admin\n2. Normal User");
        int n2 = s.nextInt();
        User user;
        if (n2 == 1) {
            user = new Admin(name, student_ID);
        } else {
            user = new NormalUser(name, student_ID);
        }
        database.AddUser(user);
        user.menu(database, user);
    }


}

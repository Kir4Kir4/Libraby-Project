package Library;

import Library.Database;
import Library.User;

import java.util.Scanner;

public class Main {

    static Scanner s;
    static Database database;

    public static void main(String[] args){

        database = new Database();
        System.out.println("Welcome to Garden Library!");

        int num;
            System.out.println( "0.Exit\n" + "1.Login\n2. New User");
            s = new Scanner(System.in);
            num  = s.nextInt();

            switch (num) {
                case 1: login();break;
                case 2: newUser();break;
            }
    }

    private static void login(){
        System.out.println("Enter student ID:");
        String student_ID = s.next();
        System.out.println("Enter name:");
        String name = s.next();
        int n = database.login(student_ID,name);
        if (n != -1){
            User user = database.getUser(n);
            user.menu(database, user);
        } else{
            System.out.println(" User doesn't exist!");
        }
    }

    private static void newUser(){
        System.out.println("Enter name:");
        String name = s.next();
        if (database.userExists(name)){
            System.out.println("User Exists!");
            newUser();
        }

        System.out.println("Enter student ID:");
        String student_ID = s.next();
        System.out.println("1. Admin\n2. Normal User");
        int n2 = s.nextInt();
        User user;
        if (n2 == 1){
            user = new Admin(name, student_ID);
        } else{
            user = new NormalUser(name, student_ID);
        }
        database.AddUser(user);
        user.menu(database, user);
    }
}

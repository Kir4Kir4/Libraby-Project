package Library;

import java.util.Scanner;

public class NormalUser extends User {

    public NormalUser(String name){
        super(name);
        this.operations = new Operation[]{
                new ViewBooks(),
                new Search(),
                new PlaceOrder(),
                new BorrowBook(),
                new CalculateFine(),
                new Exit()
        };
    }

    public NormalUser(String name, String student_ID){
        super(name, student_ID);
        this.operations = new Operation[]{
                new ViewBooks(),
                new Search(),
                new PlaceOrder(),
                new BorrowBook(),
                new CalculateFine(),
                new Exit()
        };
    }

    @Override
    public void menu(Database database, User user) {
        System.out.println("1. View Books ");
        System.out.println("2. Search ");
        System.out.println("3. Place Order");
        System.out.println("4. Borrow Book ");
        System.out.println("5. Calculate Fine");
        System.out.println("6. Return Book");
        System.out.println("7. Exit");

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        this.operations[n-1].oper(database, user);
    }
    public String toString(){
        return name+"<N/>"+student_ID+"<N/>"+"Normal User";
    }
}


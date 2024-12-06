package Library;

import java.util.Scanner;

public class CalculateFine implements Operation{
    @Override
    public void oper(Database database, User user) {
        System.out.println("Enter book name: ");
        Scanner s = new Scanner(System.in);
        String bookname = s.next();

        boolean g = true;

        for (Borrowing b: database.getBrws()){
            if (b.getBook().getName().matches(bookname) &&
            b.getUser().getName().matches(user.getName())){
                if (b.getDaysLeft() > 0 ){
                    System.out.println("You are late!"+
                            "You have to pay"+b.getDaysLeft()*50+ "as fine\n" );
                } else{
                    System.out.println("Thank you for being on time!");
                }
                g = false;
                break;
            }
        }
        if (g){
            System.out.println("You didn't borrow this book!");
        }
        user.menu(database, user);

    }
}

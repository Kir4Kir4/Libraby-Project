package Library;

import java.util.Scanner;

public class PlaceOrder implements  Operation{
    @Override
    public void oper(Database database, User user){

        Order order = new Order();

        System.out.println("\nEnter book name: ");
        Scanner s = new Scanner(System.in);
        String bookname = s.next();
        int i = database.getBook(bookname);
        if ( i <=1){
            System.out.println("Book doesn't exist!");
        } else {
            Book book = database.getBook(i);
             order.setBook(database.getBook(i));
             order.setUser(user);
             System.out.println("Enter qty: ");
             int qty = s.nextInt();
             order.setQty(qty);
             order.setPrice(book.getPrice()*qty);
             int bookindex = database.getBook(book.getName());
             book.setQty(book.getQty()-qty);
             database.addOrder(order, book, bookindex);
             System.out.println("Order placed successfully!\n");
        }
        user.menu(database, user);

    }
}

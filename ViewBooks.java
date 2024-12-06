package Library;

import java.util.ArrayList;

public class ViewBooks implements Operation{
    @Override
    public void oper(Database database, User user){

        ArrayList<Book> books = database.getAllBooks();
        System.out.println("Name\t\tAuthor\t\tPublisher\tCollection location Adress\tStatus\tQty\tPrice"
                + "\tBorrowing copies");
        for (Book b : books){
            System.out.println(b.getName()+"\t\t"+b.getAuthor()+"\t\t"+b.getPublisher()+"\t"+b.getAdress()+"\t"+
                    b.getAdress()+"\t"+b.getStatus()+"\t"+b.getQty()+"\t"+b.getPrice()+"\t"+b.getBrwcopies());
        }

    }
}

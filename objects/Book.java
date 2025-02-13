package objects;

import exceptions.BookNotAvailableException;
import exceptions.UnknownBookException;

public class Book {
    private int id;
    private String name;
    private String authorName;
    private int totalCopies;
    private int availableCopies;

    public Book(){}

    public Book(int id,String name,String authorName,int quantity){
        this.id = id;
        this.name = name;
        this.authorName = authorName;
        this.totalCopies = quantity;
        this.availableCopies = quantity;
    }

    @Override
    public String toString() {
        return this.name+" by "+this.authorName+" - "+this.totalCopies+" copies";
    }

    public int getId(){
        return this.id;
    }
    public String getBookname(){
        return this.name;
    }

    public String getAuthorName(){
        return this.authorName;
    }

    public int getQuantity(){
        return this.totalCopies;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setBookname(String bookName){
        this.name = bookName;
    }

    public void setAuthorName(String authorName){
        this.authorName = authorName;
    }

    public void setQuantity(int quantity){
        this.availableCopies = quantity - (this.totalCopies - this.availableCopies);
        this.totalCopies = quantity;
    }

    public Boolean isAvailable(){
        return this.availableCopies > 0;
    }

    public Boolean borrow() throws BookNotAvailableException{
        if(this.availableCopies <= 0) throw new BookNotAvailableException();
        this.availableCopies -= 1;
        return true;
    }
    
    public Boolean returnBook() throws UnknownBookException{
        if(this.availableCopies == this.totalCopies) throw new UnknownBookException();
        this.availableCopies += 1;
        return true;
    }
    
}

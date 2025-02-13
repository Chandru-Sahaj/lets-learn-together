package tests.objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import exceptions.BookNotAvailableException;
import exceptions.UnknownBookException;
import objects.Book;

public class BookTest {

    @Test
    public void createBookTest(){
        Book book = new Book(1, "Clean Code", "XYZ", 2);
        Assertions.assertEquals(book.getId(),1);
        Assertions.assertEquals(book.getBookname(),"Clean Code");
        Assertions.assertEquals(book.getAuthorName(),"XYZ");
        Assertions.assertEquals(book.getQuantity(),2);
    }

    @Test
    public void createBookByHelperTest(){
        Book book = new Book();
        book.setId(1);
        book.setBookname("Clean Code");
        book.setAuthorName("XYZ");
        book.setQuantity(2);
        Assertions.assertEquals(book.getId(),1);
        Assertions.assertEquals(book.getBookname(),"Clean Code");
        Assertions.assertEquals(book.getAuthorName(),"XYZ");
        Assertions.assertEquals(book.getQuantity(),2);
    }

    @Test
    public void bookToStringTest(){
        Book book = new Book(1, "Clean Code", "XYZ", 2);
        Assertions.assertEquals(book.toString(), "Clean Code by XYZ - 2 copies");
    }

    @Test
    public void bookAvailabilityTest(){
        Book book1 = new Book(1, "Clean Code", "XYZ", 2);
        Book book2 = new Book(2, "Clean Code", "XYZ", 0);
        Assertions.assertEquals(book1.isAvailable(), Boolean.TRUE);
        Assertions.assertEquals(book2.isAvailable(), Boolean.FALSE);
    }

    @Test
    public void bookBorrowTest() throws BookNotAvailableException{
        Book book1 = new Book(1, "Clean Code", "XYZ", 2);
        Assertions.assertEquals(book1.borrow(), Boolean.TRUE);
        Assertions.assertEquals(book1.borrow(), Boolean.TRUE);
        Assertions.assertThrows(BookNotAvailableException.class,()->{book1.borrow();});
        Book book = new Book();
        book.setId(2);
        book.setBookname("Refactoring");
        book.setAuthorName("ABC");
        book.setQuantity(3);
        Assertions.assertEquals(book.borrow(), Boolean.TRUE);
        Assertions.assertEquals(book.borrow(), Boolean.TRUE);
        Assertions.assertEquals(book.borrow(), Boolean.TRUE);
        Assertions.assertThrows(BookNotAvailableException.class,()->{book.borrow();});
    }

    @Test
    public void bookReturnTest() throws UnknownBookException, BookNotAvailableException{
        Book book1 = new Book(1, "Clean Code", "XYZ", 2);
        book1.borrow();
        book1.borrow();
        Assertions.assertEquals(book1.returnBook(), Boolean.TRUE);
        Assertions.assertEquals(book1.returnBook(), Boolean.TRUE);
        Assertions.assertThrows(UnknownBookException.class,()->{book1.returnBook();});
    }

    
}

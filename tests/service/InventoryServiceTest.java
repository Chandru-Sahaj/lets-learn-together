package tests.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import exceptions.BookNotFoundException;
import objects.Book;
import service.InventoryService;

public class InventoryServiceTest {

    private InventoryService inventoryService = new InventoryService();

    @Test
    public void addBookByDetailsTest(){
        Assertions.assertEquals(inventoryService.addBook(1, "Clean Code", "XYZ", 2),Boolean.TRUE);
    }

    @Test
    public void addBookByObjectTest(){
        Assertions.assertEquals(inventoryService.addBook(new Book(1, "Clean Code", "XYZ", 2)),Boolean.TRUE);
    }

    @Test
    public void getBooksTest(){
        inventoryService.addBook(new Book(2, "Clean Code", "XYZ", 2));
        inventoryService.addBook(new Book(1,"Refactoring","ABC",4));
        Assertions.assertEquals(inventoryService.getBooks().size(),2);
    }

    @Test
    public void getBooksByIDTest() throws BookNotFoundException{
        Book book = new Book(1, "Clean Code", "XYZ", 2);
        inventoryService.addBook(book);
        Assertions.assertEquals(inventoryService.getBookById(1), book);
    }

    @Test
    public void bookNotFoundTest() {
        Assertions.assertThrows(BookNotFoundException.class, ()->{inventoryService.getBookById(0);});
        Book book = new Book(1, "Clean Code", "XYZ", 2);
        Assertions.assertEquals(inventoryService.addBook(book),Boolean.TRUE);
        Assertions.assertThrows(BookNotFoundException.class, ()->{inventoryService.getBookById(0);});
    }


    
}

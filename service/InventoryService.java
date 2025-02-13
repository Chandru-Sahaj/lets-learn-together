package service;

import exceptions.BookNotAvailableException;
import exceptions.BookNotFoundException;
import exceptions.UnknownBookException;
import java.util.LinkedList;
import java.util.List;
import objects.Book;

public class InventoryService {

    private List<Book> books;

    public InventoryService(){
        this.books = new LinkedList();
    }

    public InventoryService(List<Book> books){
        this.books = books;
    }

    public Boolean addBook(int id, String bookName, String authorName,int quantity){
        return books.add(new Book(id, bookName, authorName, quantity));
    }

    public Boolean addBook(Book newBook) {
        return books.add(newBook);
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public Book getBookById(int bookId) throws BookNotFoundException {
       List<Book> filteredList = this.books.stream().filter(book->book.getId() == bookId).toList();
       if (filteredList.isEmpty()) throw new BookNotFoundException();
       return filteredList.get(0); 
    }

    public boolean borrowBook(int bookId) throws BookNotFoundException, BookNotAvailableException {
        Book book = getBookById(bookId);
        return book.borrow();
    }

    public boolean returnBook(int bookId) throws BookNotFoundException, UnknownBookException {
        Book book = getBookById(bookId);
        return book.returnBook();
    }    
}

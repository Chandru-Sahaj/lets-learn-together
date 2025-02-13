package exceptions;

public class BookNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Book not Found";
    }

}

package exceptions;

public class BookNotAvailableException extends Exception {

    @Override
    public String getMessage() {
        return "No copy of Book is available to borrow";
    }

}

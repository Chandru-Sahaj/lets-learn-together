package exceptions;

public class UnknownBookException extends Exception {

    @Override
    public String getMessage() {
        return "This copy of the book is not registered.";
    }

}

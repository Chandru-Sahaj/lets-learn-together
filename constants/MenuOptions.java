package constants;

public enum MenuOptions {

    ADD("Add a Book"),
    LIST("List all Books"),
    BORROW("Borrow Book"),
    RETURN("Return Book"),
    EXIT("Exit App");

    private final String description;

    private MenuOptions(String description) {
        this.description = description;
    };

    @Override
    public String toString() {
        return this.description;
    }

}

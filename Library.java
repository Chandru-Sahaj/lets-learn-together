
import constants.MenuOptions;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import objects.Book;
import service.InventoryService;

public class Library {

    
    private static InventoryService inventoryService = new InventoryService();

    private static Book readBookDetailsFromUser(BufferedReader reader) throws IOException{
        Book newBook = new Book();
        System.out.print("Enter Book ID:");
        newBook.setId(Integer.parseInt(reader.readLine()));
        System.out.print("Enter Book Name:");
        newBook.setBookname(reader.readLine());
        System.out.print("Enter Book Author Name:");
        newBook.setAuthorName(reader.readLine());
        System.out.print("Enter Book Quantity:");
        newBook.setQuantity(Integer.parseInt(reader.readLine()));
        return newBook;
    }
    public static void main(String[] args) throws IOException {
        MenuOptions menuOption;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (reader) {
            do { 
                int menuIndex = 0;
                System.out.println("Welcome to Melbourne Library");
                for(MenuOptions option: MenuOptions.values()){
                    System.out.println(option.ordinal()+""+option.toString());
                }
                System.out.print("Please Choose an option:");
                int option = Integer.parseInt(reader.readLine());
                menuOption = MenuOptions.values()[option - 1];
                try {
                    switch(menuOption){
                        case ADD -> inventoryService.addBook(readBookDetailsFromUser(reader));
                        case LIST -> inventoryService.getBooks().forEach(book->System.out.println(book.toString()));
                        case BORROW -> {
                            System.out.print("Enter Provide Book ID: ");
                            int bookId = Integer.parseInt(reader.readLine());
                            inventoryService.borrowBook(bookId);
                            System.out.println("Successfully borrowed book\n");
                        }
                        case RETURN -> {
                            System.out.print("Enter Provide Book ID: ");
                            int bookId = Integer.parseInt(reader.readLine());
                            inventoryService.returnBook(bookId);
                            System.out.println("Successfully returned book\n");
                        }
                        case EXIT -> {}
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println();
            } while (menuOption != MenuOptions.EXIT);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally{
            reader.close();
        }
    }
}

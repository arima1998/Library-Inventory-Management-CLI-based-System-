import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        LibraryService libraryService = new LibraryService();
        ///  populate the system
        libraryService.populateService();

        Scanner scanner = new Scanner(System.in);
        int option;
        do{
            System.out.println();
            System.out.println("Library Inventory System");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Search Items by Title");
            System.out.println("4. Calculate Late Fee");
            System.out.println("5. List All Items");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine();


            try{
                switch (option){
                    case 1 -> add(scanner, libraryService);
                    case 2 -> remove(scanner, libraryService);
                    case 3 -> search(scanner, libraryService);
                    case 4 -> calculateLateFee(scanner, libraryService);
                    case 5 -> listAllItems(libraryService);
                    case 6 -> System.out.println("Exiting system. Goodbye!");
                    default -> System.out.println("Invalid choice. Try again.");
                }
            }catch (Exception e){
                System.out.println("Error "+ e.getMessage());
            }

        }while (option != 6);
        scanner.close();

    }

    private static void add(Scanner scanner,LibraryService libraryService){
        System.out.print("Enter item type (Book/Magazine): ");
        String type = scanner.nextLine();
        System.out.print("Enter Item ID: ");
        int itemId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Year Published: ");
        int yearPublished = scanner.nextInt();
        scanner.nextLine();
        if (type.equalsIgnoreCase("Book")) {
            System.out.print("Enter Genre: ");
            String genre = scanner.nextLine();
            System.out.print("Enter ISBN: ");
            String isbn = scanner.nextLine();
            libraryService.addItem(new Book(itemId, title, author, yearPublished, genre, isbn));
        } else if (type.equalsIgnoreCase("Magazine")) {
            System.out.print("Enter Publisher: ");
            String publisher = scanner.nextLine();
            System.out.print("Enter Issue Number: ");
            String issueNumber = scanner.nextLine();
            libraryService.addItem(new Magazine(itemId, title, author, yearPublished, publisher, issueNumber));
        } else {
            System.out.println("Invalid item type.");
        }
    }
    private static void listAllItems(LibraryService libraryService) {
        libraryService.listAllItems().forEach(System.out::println);
    }

    private static void remove(Scanner scanner, LibraryService libraryService) {
        System.out.print("Enter Item ID to Remove: ");
        int itemId = scanner.nextInt();
        libraryService.removeItem(itemId);
        System.out.println("Item removed successfully!");
    }

    private static void search(Scanner scanner, LibraryService libraryService) {
        System.out.print("Enter Title to Search: ");
        String title = scanner.nextLine();
        libraryService.searchByTitle(title).forEach(System.out::println);
    }

    private static void calculateLateFee(Scanner scanner, LibraryService libraryService) {
        System.out.print("Enter Item ID: ");
        int itemId = scanner.nextInt();
        System.out.print("Enter Days Late: ");
        int daysLate = scanner.nextInt();
        double lateFee = libraryService.calculateLateFeeByItem(itemId, daysLate);
        System.out.println("Late Fee: $" + lateFee);
    }

}
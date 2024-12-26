import exceptions.DuplicateItemException;
import exceptions.ItemDoesntExistException;
import models.Book;
import factories.libraryFactory;
import service.Library;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = Library.getInstance();
        int options;

        System.out.println("CLI BASED LIBRARY INVENTORY MANAGEMENT SYSTEM");
        do{
            System.out.println("1: Add a Book");
            System.out.println("2. Remove a Book");
            System.out.println("3. Search for a Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");
            System.out.println("Enter Option");
            options = scanner.nextInt();
            try{
                switch (options){
                    case 1 -> addBook(scanner,library);
                    case 2 -> removeBook(scanner, library);
                    case 3 -> SearchBooksByIDorTitle(scanner, library);
                    case 4 -> DisplayAllBooks(library);
                    case 5 -> System.out.println("Exit!");
                    default -> System.out.println("Invalid choice.");
                }
            }
            catch (DuplicateItemException | ItemDoesntExistException e){
                System.out.println("Error: "+e.getMessage());
            }
            finally {
                System.out.println("Instruction Executed");
            }

        }while(options != 5);


    }
    private static void addBook(Scanner scanner,Library library){
        System.out.print("Enter Book ID: ");
        int itemId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Publication Year: ");
        int yearPublished = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();

        Book book = libraryFactory.createBook(itemId, title, author, yearPublished, genre);
        library.AddBook(book);
        System.out.println("Book added successfully: " + book);
    }
    private static void removeBook(Scanner scanner, Library library) {
        scanner.nextLine();
        System.out.print("Enter Book ID or Title to Remove: ");
        String IdOrTitle = scanner.nextLine();
        try{
            library.RemoveBookByIdOrTitle(IdOrTitle);
        }catch (RuntimeException e){
            System.out.println("Caught RuntimeException: "+e.getMessage());
        }
    }
    private static void SearchBooksByIDorTitle(Scanner scanner, Library library) {
        scanner.nextLine();
        System.out.print("Enter Title or Blank: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author or Blank: ");
        String author = scanner.nextLine();
        System.out.print("Enter Publication Year or Blank: ");
        String yearInput = scanner.nextLine();
        Integer year = yearInput.isEmpty() ? null : Integer.parseInt(yearInput);

        List<Book> books = library.SearchBooksByCriteria(title.isEmpty()?null:title, author.isEmpty()?null:author, year);
        if(books.isEmpty()){
            System.out.println("No Books Found");
        }
        else books.forEach(System.out::println);
    }
    private static void DisplayAllBooks(Library library) {
        library.ShowAllBooksSortedByYearDesc().forEach(System.out::println);
    }

}
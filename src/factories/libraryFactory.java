package factories;

import models.Book;


public class libraryFactory {

    public static Book createBook(int bookId, String title, String author, int publicationYear, String genre){
        return new Book(bookId,title,author,publicationYear,genre);
    }

}

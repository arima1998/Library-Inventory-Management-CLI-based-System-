package models;

public class Book {

    private int bookId;
    private String title;
    private String author;
    private int publicationYear;
    private String genre;

    public Book(int bookId, String title, String author, int publicationYear, String genre){
        this.bookId=bookId;
        this.title=title;
        this.author=author;
        this.publicationYear=publicationYear;
        this.genre = genre;
    }

    public int getBookId() {
        return bookId;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }
    @Override
    public String toString(){
        return  "Book ID: "+bookId+" Title: "+title+" Author: "+author+" Year: "+publicationYear+" Genre: "+genre;
    }

}

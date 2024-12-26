package models;

public class Book extends LibraryItem {
    private String ISBN;
    private String genre;

    public Book(int itemId, String title, String author, int yearPublished, String genre, String ISBN){
        super(itemId, title, author, yearPublished);
        this.genre = genre;
        this.ISBN = ISBN;
    }

    public String getGenre() {return genre;}
    public String getISBN() {return ISBN;}

    @Override
    public double calculateLateFee(int daysLate){
        return daysLate*0.003;
    }
    @Override
    public String toString(){
        return  super.toString() + " | Genre: "+genre+" | ISBN: "+ISBN;
    }

}

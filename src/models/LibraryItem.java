package models;

public abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;
    private int yearPublished;

    public LibraryItem(int itemId,String title,String author,int yearPublished){
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public int getItemId(){return itemId;}
    public int getYearPublished() {return yearPublished;}
    public String getAuthor() {return author;}
    public String getTitle() {return title;}

    public abstract double calculateLateFee(int daysLate);

    @Override
    public String toString(){
        return "ID: "+itemId+" | Title: "+title+" | Author: "+author+" Published Year: "+yearPublished;
    }

}



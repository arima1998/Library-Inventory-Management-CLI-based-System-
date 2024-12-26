package models;

public class Magazine extends LibraryItem {
    private String publisher;
    private String ISSN;

    public Magazine(int itemId, String title, String author, int yearPublished, String publisher, String issueNumber) {
        super(itemId, title, author, yearPublished);
        this.publisher = publisher;
        this.ISSN = issueNumber;
    }

    public String getPublisher() { return publisher; }
    public String getISSN() { return ISSN; }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 0.2;
    }

    @Override
    public String toString() {
        return super.toString() + " | Publisher: " + publisher + " | ISSN: " + ISSN;
    }
}

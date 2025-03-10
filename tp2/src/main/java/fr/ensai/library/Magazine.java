package fr.ensai.library;

/**
 * Magazine
 */
public class Magazine extends Item {
    private String issn;
    private String issueNumber;

    // Constructor
    public Magazine(String title, String issn, String issueNumber, int year, int pageCount) {
        super(title, year, pageCount);
        this.issn = issn;
        this.issueNumber = issueNumber;
    }

    @Override
    public String getDetails() {
        return "Magazine: " + title + " (ISSN: " + issn + ", Issue: " + issueNumber + ")";
    }
}

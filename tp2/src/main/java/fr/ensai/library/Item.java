package fr.ensai.library;

/**
 * Represents a generic item in the library (Book or Magazine).
 */
public abstract class Item {
    protected String title;
    protected int year;
    protected int pageCount;

    // Constructor
    public Item(String title, int year, int pageCount) {
        this.title = title;
        this.year = year;
        this.pageCount = pageCount;
    }

    // Abstract method (to be implemented in subclasses)
    public abstract String getDetails();

    @Override
    public String toString() {
        return getDetails();
    }
}

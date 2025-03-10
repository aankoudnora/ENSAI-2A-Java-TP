package fr.ensai.library;

/**
 * Represents a book.
 */
public class Book extends Item {
    private String isbn;
    private Author author;

    // Constructor
    public Book(String isbn, String title, Author author, int year, int pageCount) {
        super(title, year, pageCount);
        this.isbn = isbn;
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public String getDetails() {
        return "Book: " + title + " written by " + author.toString();
    }
}

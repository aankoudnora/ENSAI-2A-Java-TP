package fr.ensai.library;

public class Main {
    public static void main(String[] args) {
        // Create a library instance
        Library library = new Library("ENSAI Library");

        // Load books from CSV file
        String filePath = "books.csv"; 
        library.loadBooksFromCSV(filePath);

        // Display all books
        library.displayBooks();
    }
}


package fr.ensai.library;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();

        String filePath = "books.csv"; 
        try {
            library.loadBooksFromFile(filePath);
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement des livres : " + e.getMessage());
        }

        List<Book> books = library.getBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

package fr.ensai.library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Library {
    // Attributes
    private String name;
    private List<Item> items;

    // Constructor
    public Library(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    // Method to add an item to the library's collection
    public void addItem(Item item) {
        this.items.add(item);
    }

    // Method to display all items in the library
    public void displayItems() {
        System.out.println("\n***************************");
        System.out.println("*       All Books         *");
        System.out.println("***************************");

        if (this.items.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            for (Item item : this.items) {
                System.out.println(item);
            }
        }
    }

    /**
     * Loads books from a CSV file and adds them to the library.
     * 
     * @param filePath The path to the CSV file containing book data.
     * @throws IOException If there is an error reading the file, an
     *                     {@link IOException} will be thrown.
     */
    public void loadBooksFromCSV(String filePath) {
        URL url = getClass().getClassLoader().getResource(filePath);

        if (url == null) {
            System.err.println("Error: File not found -> " + filePath);
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(url.getFile()))) {
            Map<String, Author> authors = new HashMap<>();
            String line;
            br.readLine(); // Skip the header line

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length == 5) {
                    String isbn = data[0].trim();
                    String title = data[1].trim();
                    String authorName = data[2].trim();
                    int year = Integer.parseInt(data[3].trim());
                    int pageCount = Integer.parseInt(data[4].trim());

                    // Check if the author already exists
                    Author author = authors.get(authorName);
                    if (author == null) {
                        // Correction : Ajout d'un âge et d'une nationalité par défaut
                        author = new Author(authorName, 40, "Unknown"); 
                        authors.put(authorName, author);
                    }

                    Book book = new Book(isbn, title, author, year, pageCount);
                    this.addItem(book);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}

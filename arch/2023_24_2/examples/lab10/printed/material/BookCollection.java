package printed.material;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import printed.material.specific.DamagedBook;
import printed.material.specific.EBook;
import printed.material.specific.PrintedBook;

public class BookCollection {
    private ArrayList<Book> books;

    public BookCollection() {
        books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public void add(Book... books) {
        for (Book book : books) {
            this.books.add(book);
        }
    }

    public boolean save(String filename) {
        try (PrintWriter pw = new PrintWriter(filename)) {
            for (Book book : getBooks()) {
                pw.printf("%s--%s%n", book.getClass().getSimpleName(), book);
            }
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    public static BookCollection load(String filename) {
        BookCollection bookCollection = new BookCollection();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while (true) {
                String line = br.readLine();
                if (line == null)   break;

                try {
                    String[] split = line.split("--");

                    String type = split[0].strip();
                    Book decoded = switch (type) {
                    case "Book" -> Book.decode(split[1]);
                    case "PrintedBook" -> PrintedBook.decode(split[1]);
                    case "EBook" -> EBook.decode(split[1]);
                    default -> throw new IllegalArgumentException();
                    };
                    bookCollection.books.add(decoded);
                } catch (Exception e) {
                    bookCollection.books.add(new DamagedBook());
                }
            }
        } catch (IOException e) {
            // ignored
        }

        return bookCollection;
    }
}

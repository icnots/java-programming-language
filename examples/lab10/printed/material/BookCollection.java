package printed.material;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

import printed.material.specific.DamagedBook;
import printed.material.specific.PrintedBook;
import printed.material.specific.EBook;

public class BookCollection{
    private ArrayList<Book> books;
    public ArrayList<Book> getBooks(){
        return new ArrayList<>(books);
    }

    public BookCollection(){
        books = new ArrayList<>();
    }

    public void add(Book... books){
        for (Book book : books){
            this.books.add(book);
        }
    }

    public static BookCollection load(String filename){
        BookCollection bc = new BookCollection();

        try (
            BufferedReader br = new BufferedReader(new FileReader(filename));){
            String line = br.readLine();
            while (null != line){
                try {
                    String[] items = line.split("--");
                    String type = items[0].strip();
                    if (type.equals("Book")){
                        bc.add(Book.decode(items[1]));
                    }else if (type.equals("PrintedBook")){
                        bc.add(PrintedBook.decode(items[1]));
                    }else{
                        bc.add(new DamagedBook());
                    }
                }catch (InvalidBookException e){
                    // if here another InvalidBookException is thrown, then skip
                    try {
                        bc.add(new DamagedBook());
                    }catch(InvalidBookException e2){
                        // skip
                    }
                }
                line = br.readLine();
            }
        }catch(IOException e){
            return new BookCollection();
        }

        return bc;
    }

    public boolean save(String filename){
        try (
            PrintWriter pw = new PrintWriter(filename);
        ){
            for (Book book : books){
                if (book instanceof EBook){
                    pw.print("EBook--");
                    pw.println(book.toString());
                }else if (book instanceof PrintedBook){
                    pw.print("PrintedBook--");
                    pw.println(book.toString());
                }else if (book instanceof DamagedBook){
                    pw.println("DamagedBook");
                }else if (book instanceof Book){
                    pw.print("Book--");
                    pw.println(book.toString());
                }else{
                    pw.println("DamagedBook");
                }
            }
        }catch(IOException e){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        /*
        BookCollection bc = new BookCollection();

        try{
            bc.add(
                new Book("John Steinbeck", "Of Mice and Men", 107),
                new Book("abcd", "ABCD", 123),
                new EBook(new Book("abcd", "ABCD", 123), 234, false, "$"),
                new PrintedBook("abcd", "ABCD", 123, CoverType.HARDCOVER)
            );

            bc.save("examples.txt");
        }catch(InvalidBookException e){
            System.err.println("InvalidBookException occured.");
        }
        */
        BookCollection bc = BookCollection.load("test.in");
        bc.save("test.out");
    }
}
package printed.material;

import static org.junit.Assert.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import printed.material.specific.DamagedBook;
import printed.material.specific.EBook;
import printed.material.specific.PrintedBook;

public class BookCollectionTest {
    @Test
    public void test() {
        BookCollection bc = new BookCollection();
        bc.save("empty.books.txt");
    }

    @Test
    public void testSaveLoad() {
        BookCollection bc = new BookCollection();
        bc.add(new Book());

        bc.save("default.books.txt");
        BookCollection bc2 = BookCollection.load("default.books.txt");

        assertEquals(1, bc2.getBooks().size());

        Book book1 = bc2.getBooks().get(0);
        assertEquals(Book.defaultAuthor, book1.getAuthor());
        assertEquals(Book.defaultTitle, book1.getTitle());
        assertEquals(Book.defaultPageCount, book1.getPageCount());
    }

    @Test
    public void testSaveLoad2() throws InvalidBookException {
        BookCollection bc = new BookCollection();
        bc.add(
            new Book(),
            new Book("abcd", "ABCD", 123),
            new EBook(new Book("abcd", "ABCD", 123), 234, false, "$"),
            new PrintedBook("abcd", "ABCD", 123, CoverType.HARDCOVER)
        );

        bc.save("more.books.txt");
        BookCollection bc2 = BookCollection.load("more.books.txt");

        assertNotSame(bc, bc2);

        assertEquals(4, bc2.getBooks().size());

        Book book1 = bc2.getBooks().get(0);
        Book book2 = bc2.getBooks().get(1);
        Book book3 = bc2.getBooks().get(2);
        Book book4 = bc2.getBooks().get(3);

        assertTrue(book1 instanceof Book);
        assertEquals(Book.defaultAuthor, book1.getAuthor());
        assertEquals(Book.defaultTitle, book1.getTitle());
        assertEquals(Book.defaultPageCount, book1.getPageCount());

        assertTrue(book2 instanceof Book);
        assertEquals(Book.defaultAuthor, book1.getAuthor());
        assertEquals(Book.defaultTitle, book1.getTitle());
        assertEquals(Book.defaultPageCount, book1.getPageCount());

        assertTrue(book3 instanceof DamagedBook);
        assertEquals(Book.defaultAuthor, book1.getAuthor());
        assertEquals(Book.defaultTitle, book1.getTitle());
        assertEquals(Book.defaultPageCount, book1.getPageCount());

        assertTrue(book4 instanceof PrintedBook);
        assertEquals(Book.defaultAuthor, book1.getAuthor());
        assertEquals(Book.defaultTitle, book1.getTitle());
        assertEquals(Book.defaultPageCount, book1.getPageCount());
    }
}

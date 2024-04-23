package printed.material.specific;

import printed.material.Book;
import printed.material.CoverType;
import printed.material.InvalidBookException;

public class PrintedBook extends Book {
    protected CoverType coverType;

    public PrintedBook(Book book) throws InvalidBookException {
        this(book.getAuthor(), book.getTitle(), book.getPageCount(), CoverType.HARDCOVER);
    }

    public PrintedBook(String author, String title, int pageCount, CoverType coverType) throws InvalidBookException {
        super(author, title, pageCount + 6);
        this.coverType = coverType;
    }

    @Override
    public int getPrice() {
        var multiplier = coverType == CoverType.SOFTCOVER ? 2 : 3;
        return getPageCount() * multiplier;
    }

    @Override
    public String toString() {
        return "%s (%s)".formatted(super.toString(), coverType);
    }

    public static PrintedBook decode(String text) throws InvalidBookException {
        String[] split1 = text.split("[(]");
        String[] split2 = split1[1].split("[)]");

        Book asBook = Book.decode(split1[0].strip());
        CoverType coverType = CoverType.valueOf(split2[0]);
        return new PrintedBook(asBook.getAuthor(), asBook.getTitle(), asBook.getPageCount()-6, coverType);
    }
}

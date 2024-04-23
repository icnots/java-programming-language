package printed.material.specific;

import printed.material.Book;
import printed.material.InvalidBookException;

public class EBook extends Book {
    private int pdfSize;
    private boolean isUnitPrefix;
    private String unit;

    public EBook(Book book, int pdfSize, boolean isUnitPrefix, String unit) throws InvalidBookException {
        super(book.getAuthor(), book.getTitle(), book.getPageCount());
        this.pdfSize = pdfSize;
        this.isUnitPrefix = isUnitPrefix;
        this.unit = unit;
    }

    @Override
    public int getPrice() {
        return getPageCount() + pdfSize;
    }

    @Override
    public String toString() {
        var cost = getPrice() <= 1_000 ? "%d.99".formatted(getPrice()-1) : "%d".formatted(getPrice()-1);
        return "EBook(%s, %s%s%s)".formatted(super.toString(), isUnitPrefix ? unit : "", cost, isUnitPrefix ? "" : unit);
    }

    public static EBook decode(String text) {
        throw new UnsupportedOperationException();
    }
}

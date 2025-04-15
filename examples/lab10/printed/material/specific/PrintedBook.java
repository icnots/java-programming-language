package printed.material.specific;

import printed.material.Book;
import printed.material.CoverType;
import printed.material.InvalidBookException;

public class PrintedBook extends Book{
    protected CoverType coverType;
    
    public PrintedBook(String author, String title, int pageCount, CoverType coverType) throws InvalidBookException{
        super(author, title, pageCount+6);

        this.coverType = coverType;
    }

    public PrintedBook(Book book) throws InvalidBookException{
        this(book.getAuthor(), book.getTitle(), book.getPageCount(), CoverType.HARDCOVER);
    }

    public static PrintedBook decode(String text) throws InvalidBookException{
        String[] items = text.split("[:;()]");

        return new PrintedBook(
            items[0].strip(),
            items[1].strip(),
            Integer.parseInt(items[2].strip()),
            CoverType.valueOf(items[3].strip())
        );
    }

    public int getPrice(){
        if (coverType == CoverType.HARDCOVER){
            return getPageCount() * 3;
        }else{
            return getPageCount() * 2;
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append(" (");
        sb.append(coverType);
        sb.append(")");

        return sb.toString();
    }
}
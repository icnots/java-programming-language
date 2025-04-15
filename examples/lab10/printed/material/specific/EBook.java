package printed.material.specific;

import printed.material.Book;
import printed.material.InvalidBookException;

public class EBook extends Book{
    private int pdfSize;
    private boolean isUnitPrefix;
    private String unit;

    public EBook(Book book, int pdfSize, boolean isUnitPrefix, String unit) throws InvalidBookException{
        super(book.getAuthor(), book.getTitle(), book.getPageCount());

        this.pdfSize = pdfSize;
        this.isUnitPrefix = isUnitPrefix;
        this.unit = unit;
    }

    public static EBook decode(String text){
        throw new UnsupportedOperationException();
    }

    public int getPrice(){
        return pageCount + pdfSize;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("EBook(");
        sb.append(super.toString());
        sb.append(", ");
        if (isUnitPrefix){
            sb.append(unit);
        }
        int price = getPrice();
        if (price <= 1000){
            sb.append(price - 0.01);
        }else{
            sb.append(price);
        }
        if (!isUnitPrefix){
            sb.append(" ");
            sb.append(unit);
        }
        sb.append(")");
        
        return sb.toString();
    }
}
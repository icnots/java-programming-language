package printed.material.specific;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

import printed.material.Book;
import printed.material.InvalidBookException;

public class EBookTest{
    @ParameterizedTest(name = "{6} is correct")
    @CsvSource(textBlock = """
        John Steinbeck, Of Mice and Men, 107, 5, true, $, 'EBook(John Steinbeck: Of Mice and Men; 107, $111.99)'
        Kozsik Tamás, Java programozás, 234, 10000, false, Ft, 'EBook(Kozsik Tamás: Java programozás; 234, 10234 Ft)'
        Alan Alexander Milne, Winnie-the-Pooh, 145, 8, true, £, 'EBook(Alan Alexander Milne: Winnie-the-Pooh; 145, £152.99)'
    """)
    @DisableIfHasBadStructure
    public void testToString(String author, String title, int pageCount, int pdfSize, boolean isUnitPrefix, String unit, String expected){
        try{
            EBook eb = new EBook(new Book(author, title, pageCount), pdfSize, isUnitPrefix, unit);
            assertEquals(expected, eb.toString());
        }catch(InvalidBookException e){
            fail();
        }
    }
}

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
import printed.material.CoverType;
import printed.material.InvalidBookException;

public class PrintedBookTest{
    @ParameterizedTest(name = "{4} is correct with price")
    @CsvSource(textBlock = """
        John Steinbeck, Of Mice and Men, 107, SOFTCOVER, 'John Steinbeck: Of Mice and Men; 113 (SOFTCOVER)', 226
        John Steinbeck, Of Mice and Men, 107, HARDCOVER, 'John Steinbeck: Of Mice and Men; 113 (HARDCOVER)', 339
        Kozsik Tamás, Java programozás, 234, SOFTCOVER, 'Kozsik Tamás: Java programozás; 240 (SOFTCOVER)', 480
        Kozsik Tamás, Java programozás, 234, HARDCOVER, 'Kozsik Tamás: Java programozás; 240 (HARDCOVER)', 720
        Alan Alexander Milne, Winnie-the-Pooh, 145, SOFTCOVER, 'Alan Alexander Milne: Winnie-the-Pooh; 151 (SOFTCOVER)', 302
        Alan Alexander Milne, Winnie-the-Pooh, 145, HARDCOVER, 'Alan Alexander Milne: Winnie-the-Pooh; 151 (HARDCOVER)', 453
    """)
    @DisableIfHasBadStructure
    public void testToString(String author, String title, int pageCount, CoverType coverType, String expected, int expectedPrice){
        try{
            PrintedBook pb = new PrintedBook(author, title, pageCount, coverType);
            assertEquals(expected, pb.toString());
            assertEquals(expectedPrice, pb.getPrice());
        }catch(InvalidBookException e){
            fail();
        }
    }
}

package printed.material;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

public class BookTest{
    @Test
    public void testJS(){
        try{
            Book b = new Book("John Steinbeck", "Of Mice and Men", 107);

            assertEquals("John Steinbeck: Of Mice and Men; 107", b.toString());
            assertEquals("J. Steinbeck: Of M; 107", b.getShortInfo());
        }catch(InvalidBookException e){
            fail();
        }
    }

    @Test
    public void testKT(){
        try{
            Book b = new Book("Kozsik Tamás", "Java programozás", 234);

            assertEquals("Kozsik Tamás: Java programozás; 234", b.toString());
            assertEquals("K. Tamás: Java; 234", b.getShortInfo());
        }catch(InvalidBookException e){
            fail();
        }
    }

    @Test
    public void testAAM(){
        try{
            Book b = new Book("Alan Alexander Milne", "Winnie-the-Pooh", 145);

            assertEquals("Alan Alexander Milne: Winnie-the-Pooh; 145", b.toString());
            assertEquals("A. A. Milne: Winn; 145", b.getShortInfo());
        }catch(InvalidBookException e){
            fail();
        }
    }

    @ParameterizedTest(name = "{0}: {1}; {2} is invalid")
    @CsvSource(textBlock = """
        J, Alma, 100
        John, Al, 100
        John, Alma, -123
    """)
    @DisableIfHasBadStructure
    public void testInvalidBookException(String author, String title, int pageCount){
        try{
            Book b = new Book(author, title, pageCount);
            fail();
        }catch(InvalidBookException e){
            assertEquals(author, e.getAuthor());
            assertEquals(title, e.getTitle());
            // intentionally return
            return;
        }

        fail();
    }


}
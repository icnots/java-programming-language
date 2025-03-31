package text.to.numbers;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

import java.io.IOException;

public class MultiLineFileTest {
    @Test
    public void testEmptyFile(){
        try{
            int num = MultiLineFile.addNumbers("emptyFile.txt", ' ');

            assertEquals(0, num);
        }
        catch(IOException e){
            fail();
        }
    }

    @Test
    public void testWrongFilename(){
        try{
            MultiLineFile.addNumbers("wrongFilename.textfile", ' ');
        }
        catch(IOException e){
            return;
        }
        // intentionally fails if test gets here.
        fail();
    }

    @Test
    public void testNormalInputWhitespace(){
        try{
            int num = MultiLineFile.addNumbers("normalSingleLineFile.txt", ' ');

            assertEquals(-117, num);
        }
        catch(IOException e){
            fail();
        }
    }

    @Test
    public void testNormalInputComma(){
        try{
            int num = MultiLineFile.addNumbers("normalMultiLineFileComma.txt", ',');

            assertEquals(-351, num);
        }
        catch(IOException e){
            fail();
        }
    }
}
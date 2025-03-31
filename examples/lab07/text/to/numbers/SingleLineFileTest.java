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

public class SingleLineFileTest {
    @Test
    public void testEmptyFile(){
        try{
            SingleLineFile.addNumbers("emptyFile.txt");
        }
        catch(IllegalArgumentException e){
            assertEquals("Empty file", e.getMessage());
            return;
        }
        catch(IOException e){
            fail();
        }
        // intentionally fails if test gets here.
        fail();
    }

    @Test
    public void testWrongFilename(){
        try{
            SingleLineFile.addNumbers("wrongFilename.textfile");
        }
        catch(IOException e){
            return;
        }
        // intentionally fails if test gets here.
        fail();
    }

    @Test
    public void testNormalInput(){
        try{
            int num = SingleLineFile.addNumbers("normalSingleLineFile.txt");

            assertEquals(-117, num);
        }
        catch(IOException e){
            fail();
        }

    }
}
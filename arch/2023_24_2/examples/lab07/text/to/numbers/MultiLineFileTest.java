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

public class MultiLineFileTest{
    @Test
    public void invalidFile(){
        try {
            MultiLineFile.addNumbers("nonExistentFileName.txt", ' ');
            fail();
        } catch (IOException e) {
            // the test is succesful
        } catch (Exception e) {
            // any other exception
            fail();
        }
    }

    @Test
    public void emptyFile(){
        try {
            int val = MultiLineFile.addNumbers("emptyFile.txt", ' ');
            assertEquals(0, val);
        } catch (IOException e){
            fail();
        } catch (Exception e) {
            // any other exception
            fail();
        }
    }

    @Test
    public void oneRowFile(){
        try {
            int sum = MultiLineFile.addNumbers("numbers.txt", ' ');
            assertEquals(-117, sum);
        } catch (IOException e){
            fail();
        } catch (Exception e) {
            // any other exception
            fail();
        }
    }

    @Test
    public void multiRowsFileWithSpace(){
        try {
            int sum = MultiLineFile.addNumbers("multiLineSpace.txt", ' ');
            assertEquals(55, sum);
        } catch (IOException e){
            fail();
        } catch (Exception e) {
            // any other exception
            fail();
        }
    }

    @Test
    public void multiRowsFileWithComma(){
        try {
            int sum = MultiLineFile.addNumbers("multiLineComma.txt", ',');
            assertEquals(55, sum);
        } catch (IOException e){
            fail();
        } catch (Exception e) {
            // any other exception
            fail();
        }
    }
}
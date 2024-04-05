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

public class SingleLineFileTest{
    @Test
    public void invalidFile(){
        try {
            SingleLineFile.addNumbers("nonExistentFileName.txt");
            fail();
        } catch (IOException e) {
            // the test is succesful
        } catch (Exception e) {
            // any other exceptions
            fail();
        }
    }

    @Test
    public void emptyFile(){
        try {
            SingleLineFile.addNumbers("emptyFile.txt");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Empty file", e.getMessage());
        } catch (IOException e){
            fail();
        } catch (Exception e) {
            // any other exceptions
            fail();
        }
    }

    @Test
    public void validFile(){
        try {
            int sum = SingleLineFile.addNumbers("numbers.txt");
            assertEquals(-117, sum);
        } catch (IOException e){
            fail();
        } catch (Exception e) {
            // any other exceptions
            fail();
        }
    }
}
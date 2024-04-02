package textfile.lookup;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

public class FileContentTest{
    @Test
    public void testNotContainingContentValue(){
        int val = FileContent.contentLineCount("multiLineSpace.txt", "QQ");

        assertEquals(0, val);
    }

    @Test
    public void testContainingContentValue(){
        int val = FileContent.contentLineCount("multiLineSpace.txt", "1");

        assertEquals(4, val);
    }
    
    @Test
    public void testNotContainingContentValues(){
        int[] vals = FileContent.contentLineNumbers("multiLineSpace.txt", "QQ");
        int[] expected = new int[0];

        assertArrayEquals(expected, vals);
    }

    @Test
    public void testContainingContentValues(){
        int[] vals = FileContent.contentLineNumbers("multiLineSpace.txt", "1");
        int[] expected = new int[]{0, 1, 3, 4};

        assertArrayEquals(expected, vals);
    }
}
package textfile;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

public class StatisticsTest{
    @Test
    public void testNumberOfLinesEmptyFile(){
        int val = Statistics.numberOfLines("emptyFile.txt");

        assertEquals(0, val);
    }
    
    @Test
    public void testNumberOfLinesValidFile(){
        int val = Statistics.numberOfLines("multiLineSpace.txt");

        assertEquals(5, val);
    }

    @Test
    public void testNumberOfCharactersEmptyFile(){
        int val = Statistics.numberOfCharacters("emptyFile.txt");

        assertEquals(0, val);
    }
    
    @Test
    public void testNumberOfCharactersValidFile(){
        int val = Statistics.numberOfCharacters("multiLineSpace.txt");

        assertEquals(132, val);
    }
}
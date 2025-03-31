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
    public void testEmptyFileCharacters(){
        assertEquals(0, Statistics.numberOfCharacters("emptyFile.txt"));
    }

    @Test
    public void testWrongFileCharacters(){
        assertEquals(0, Statistics.numberOfCharacters("wrongFilename.textfile"));
    }

    @Test
    public void testEmptyFileLines(){
        assertEquals(0, Statistics.numberOfLines("emptyFile.txt"));
    }

    @Test
    public void testWrongFileLines(){
        assertEquals(0, Statistics.numberOfLines("wrongFilename.textfile"));
    }
    
    @Test
    public void testNumberOfCharacters(){
        assertEquals(57, Statistics.numberOfCharacters("normalMultiLineFileComma.txt"));
    }
    
    @Test
    public void testNumberOfLines(){
        assertEquals(3, Statistics.numberOfLines("normalMultiLineFileComma.txt"));
    }
}
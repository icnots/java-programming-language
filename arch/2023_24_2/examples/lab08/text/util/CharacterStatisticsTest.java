package text.util;


import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;


public class CharacterStatisticsTest{
    @Test
    public void testWordaaaaaaaa(){
        CharacterStatistics cs = new CharacterStatistics("aaaaaaaa");
        assertEquals(8, cs.getCount('a'));

        assertEquals(0, cs.getCount('b'));

        assertEquals("[a=8]", cs.toString());
    }

    @Test
    public void testWordHgFeDcBa(){
        CharacterStatistics cs = new CharacterStatistics("HgFeDcBa");
        assertEquals(1, cs.getCount('H'));
        assertEquals(1, cs.getCount('g'));
        assertEquals(1, cs.getCount('F'));
        assertEquals(1, cs.getCount('e'));
        assertEquals(1, cs.getCount('D'));
        assertEquals(1, cs.getCount('c'));
        assertEquals(1, cs.getCount('B'));
        assertEquals(1, cs.getCount('a'));

        assertEquals(0, cs.getCount('X'));

        assertEquals("[a=1, B=1, c=1, D=1, e=1, F=1, g=1, H=1]", cs.toString());
    }

    @Test
    public void testWordWithRandomCharacters(){
        CharacterStatistics cs = new CharacterStatistics("a?!_#@{}");
        assertEquals(1, cs.getCount('a'));
        assertEquals(1, cs.getCount('?'));
        assertEquals(1, cs.getCount('!'));
        assertEquals(1, cs.getCount('_'));
        assertEquals(1, cs.getCount('#'));
        assertEquals(1, cs.getCount('@'));
        assertEquals(1, cs.getCount('{'));
        assertEquals(1, cs.getCount('}'));

        assertEquals(0, cs.getCount(';'));
        
        assertEquals("[@=1, a=1, !=1, #=1, {=1, }=1, ?=1, _=1]", cs.toString());
    }

    @Test
    public void testHelloWorld(){
        CharacterStatistics cs = new CharacterStatistics("Hello world!:");
        assertEquals(1, cs.getCount(' '));
        assertEquals(1, cs.getCount('!'));
        assertEquals(1, cs.getCount('r'));
        assertEquals(1, cs.getCount('d'));
        assertEquals(1, cs.getCount('e'));
        assertEquals(1, cs.getCount('w'));
        assertEquals(1, cs.getCount('H'));
        assertEquals(3, cs.getCount('l'));
        assertEquals(2, cs.getCount('o'));

        assertEquals(0, cs.getCount(';'));

        assertEquals("[ =1, !=1, r=1, d=1, e=1, w=1, H=1, :=1, l=3, o=2]", cs.toString());
    }
}
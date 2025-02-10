package data.organiser;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

public class OrganiserTest{
    @Test
    public void testInteger() {
        Organiser<Integer> organiser = new Organiser<>(1, 3, 5, 7, 9);
        assertEquals("[1 3 5 7 9 ]", organiser.toString());

        organiser.addSwap(0, 1);
        organiser.runSwaps();

        assertEquals("[3 1 5 7 9 ]", organiser.toString());
        
        organiser.runSwaps();
        assertEquals("[1 3 5 7 9 ]", organiser.toString());

        organiser.addSwap(0, 3);
        organiser.runSwaps();
        assertEquals("[7 1 5 3 9 ]", organiser.toString());

        int elem = organiser.get(0).intValue();
        assertEquals(7, elem);
    }

    @Test
    public void testString() {
        Organiser<String> organiser = new Organiser<>("a b c d e".split(" "));
        assertEquals("[a b c d e ]", organiser.toString());

        organiser.addSwap(0, 1);
        organiser.runSwaps();
        assertEquals("[b a c d e ]", organiser.toString());

        organiser.runSwaps();
        assertEquals("[a b c d e ]", organiser.toString());

        organiser.addSwap(0, 3);
        organiser.runSwaps();
        assertEquals("[d a c b e ]", organiser.toString());

        String elem = organiser.get(0);
        assertEquals("d", elem);
    }

}
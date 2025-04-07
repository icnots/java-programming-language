package data.organiser;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

import java.util.List;
import java.util.ArrayList;

public class OrganiserTest{
    @Test
    public void testInteger(){
        Organiser<Integer> o = new Organiser<>(1, 2, 3, 4, 5);

        o.addSwap(0, 3);
        o.addSwap(2, 3);
        o.runSwaps();

        assertEquals(1, o.get(2));
        assertEquals("[4 2 1 3 5 ]", o.toString());
        assertEquals(
            new ArrayList<Integer>(List.of(4, 2, 1, 3, 5)),
            o.get()
        );
    }

    @Test
    public void testCharacter(){
        Organiser<Character> o = new Organiser<>('a', 'b', 'c', 'd', 'e');

        o.addSwap(3, 0);
        o.addSwap(3, 1);
        o.runSwaps();

        assertEquals('a', o.get(1));
        assertEquals("[d a c b e ]", o.toString());
        assertEquals(
            new ArrayList<Character>(List.of('d', 'a', 'c', 'b', 'e')),
            o.get()
        );
    }
}
package data.structure;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

import java.util.ArrayList;
import java.util.Arrays;

public class RangedStackTest{
    @Test
    public void empty(){
        RangedStack<Integer> rs = new RangedStack<>();

        assertEquals(new ArrayList<Integer>(), rs.pop(0));
        assertEquals(new ArrayList<Integer>(), rs.pop(1));
        assertEquals(new ArrayList<Integer>(), rs.pop(100));
    }

    @Test
    public void testString(){
        RangedStack<String> rs = new RangedStack<>();

        rs.push("2 4 6 8 10 12".split(" "));

        RangedStack<String> copy = new RangedStack<>(rs);

        assertEquals(
            new ArrayList<String>(Arrays.asList("12")),
            rs.pop(1)
        );
        assertEquals(
            new ArrayList<String>(Arrays.asList("10", "8")),
            rs.pop(2)
        );
        assertEquals(
            new ArrayList<String>(Arrays.asList("6", "4", "2")),
            rs.pop(3)
        );
        assertEquals(
            new ArrayList<String>(),
            rs.pop(100)
        );

        assertEquals(
            new ArrayList<String>(Arrays.asList("12", "10", "8", "6", "4", "2")),
            copy.pop(100)
        );
        assertEquals(
            new ArrayList<String>(),
            copy.pop(100)
        );
    }

    @Test
    public void testInteger(){
        RangedStack<Integer> rs = new RangedStack<>();

        rs.push(2, 4, 6, 8, 10, 12);

        RangedStack<Integer> copy = new RangedStack<>(rs);

        assertEquals(
            new ArrayList<Integer>(Arrays.asList(12)),
            rs.pop(1)
        );
        assertEquals(
            new ArrayList<Integer>(Arrays.asList(10, 8)),
            rs.pop(2)
        );
        assertEquals(
            new ArrayList<Integer>(Arrays.asList(6, 4, 2)),
            rs.pop(3)
        );
        assertEquals(
            new ArrayList<Integer>(),
            rs.pop(100)
        );

        assertEquals(
            new ArrayList<Integer>(Arrays.asList(12, 10, 8, 6, 4, 2)),
            copy.pop(100)
        );
        assertEquals(
            new ArrayList<Integer>(),
            copy.pop(100)
        );
    }
}
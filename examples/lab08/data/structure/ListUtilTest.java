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
import static java.util.Arrays.asList;

public class ListUtilTest{
    @Test
    public void testDivisorsOf0(){
        ArrayList<Integer> expected = new ArrayList<>();

        assertEquals(expected, ListUtil.divisors(0));

        // equivalent:
        assertTrue(expected.equals(ListUtil.divisors(0)));
    }

    @Test
    public void testDivisorsOf1(){
        ArrayList<Integer> expected = new ArrayList<>(asList(1));

        assertEquals(expected, ListUtil.divisors(1));

        // equivalent:
        assertTrue(expected.equals(ListUtil.divisors(1)));
    }

    @Test
    public void testDivisorsOf64(){
        ArrayList<Integer> expected = new ArrayList<>(asList(1, 2, 4, 8, 16, 32, 64));
        
        assertEquals(expected, ListUtil.divisors(64));

        // equivalent:
        assertTrue(expected.equals(ListUtil.divisors(64)));
    }

    @Test
    public void testWithSameStartEnd(){
        ArrayList<String> workingArray = new ArrayList<>();
        ArrayList<String> expected = new ArrayList<>();
        
        assertEquals(expected, ListUtil.withSameStartEnd(workingArray));

        workingArray.add("");
        expected = new ArrayList<>();

        assertEquals(expected, ListUtil.withSameStartEnd(workingArray));

        workingArray.add(null);
        expected = new ArrayList<>();

        assertEquals(expected, ListUtil.withSameStartEnd(workingArray));

        workingArray.add(" ");
        expected = new ArrayList<>(asList(" "));

        assertEquals(expected, ListUtil.withSameStartEnd(workingArray));

        workingArray.add("x");
        expected = new ArrayList<>(asList(" ", "x"));

        assertEquals(expected, ListUtil.withSameStartEnd(workingArray));

        workingArray.add("");
        expected = new ArrayList<>(asList(" ", "x"));

        assertEquals(expected, ListUtil.withSameStartEnd(workingArray));

        workingArray.add("different start and end?");
        expected = new ArrayList<>(asList(" ", "x"));

        assertEquals(expected, ListUtil.withSameStartEnd(workingArray));

        workingArray.add("ends and starts the same");
        expected = new ArrayList<>(asList(" ", "x", "ends and starts the same"));

        assertEquals(expected, ListUtil.withSameStartEnd(workingArray));
    }

    @Test
    public void testMaxToFrontWithNull(){
        ArrayList<String> workingArray = null;

        ListUtil.maxToFront(workingArray);
    }

    @Test
    public void testMaxToFrontWithEmptyList(){
        ArrayList<String> workingArray = new ArrayList<>();

        ListUtil.maxToFront(workingArray);

        assertEquals(new ArrayList<String>(), workingArray);
    }

    @Test
    public void testMaxToFrontWithOneElement(){
        ArrayList<String> workingArray = new ArrayList<>(asList("Hello"));

        ListUtil.maxToFront(workingArray);

        assertEquals(new ArrayList<>(asList("Hello")), workingArray);
    }

    @Test
    public void testMaxToFrontWithThreeElementWords(){
        ArrayList<String> workingArray = new ArrayList<>(asList("can", "you", "succeed"));

        ListUtil.maxToFront(workingArray);

        assertEquals(
            new ArrayList<>(asList("you", "can", "succeed")),
            workingArray
        );
    }

    @Test
    public void testMaxToFrontWithThreeElementNumbers(){
        ArrayList<String> workingArray = new ArrayList<>(asList("-123", "2000", "100"));

        ListUtil.maxToFront(workingArray);

        assertEquals(
            new ArrayList<>(asList("2000", "-123", "100")),
            workingArray
        );
    }
}
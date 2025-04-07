package data.structure;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;


public class MultiSetTest {
    @Test
    public void multiSetInteger(){
        MultiSet<Integer> ms = new MultiSet<>();

        ms.add(10);
        ms.add(10);
        ms.add(10);
        ms.add(20);
        ms.add(30);
        ms.add(30);
        
        assertEquals(0, ms.getCount(0));
        assertEquals(3, ms.getCount(10));
        assertEquals(1, ms.getCount(20));
        assertEquals(2, ms.getCount(30));
        assertEquals(0, ms.getCount(40));
    }

    @Test
    public void multiSetString(){
        MultiSet<String> ms = new MultiSet<>();

        ms.add("alma");
        ms.add("alma");
        ms.add("alma");
        ms.add("barack");
        ms.add("citrom");
        ms.add("citrom");
        
        assertEquals(3, ms.getCount("alma"));
        assertEquals(1, ms.getCount("barack"));
        assertEquals(2, ms.getCount("citrom"));
        assertEquals(0, ms.getCount("dinnye"));
        assertEquals(0, ms.getCount("eper"));
    }

    @Test
    public void testIntersect(){
        MultiSet<String> ms1 = new MultiSet<>();

        ms1.add("alma");
        ms1.add("alma");
        ms1.add("alma");
        ms1.add("barack");
        ms1.add("citrom");
        ms1.add("citrom");
        
        MultiSet<String> ms2 = new MultiSet<>();

        ms2.add("alma");
        ms2.add("citrom");
        ms2.add("citrom");
        ms2.add("dinnye");
        ms2.add("dinnye");

        MultiSet<String> intersection = ms1.intersect(ms2);
        assertEquals(1, intersection.getCount("alma"));
        assertEquals(0, intersection.getCount("barack"));
        assertEquals(2, intersection.getCount("citrom"));
        assertEquals(0, intersection.getCount("dinnye"));
        assertEquals(0, intersection.getCount("eper"));
    }

    @Test
    public void testCountExcept(){
        MultiSet<String> ms = new MultiSet<>();

        ms.add("alma");
        ms.add("alma");
        ms.add("alma");
        ms.add("barack");
        ms.add("citrom");
        ms.add("citrom");

        assertEquals(6, ms.size());
        assertEquals(3, ms.countExcept("alma"));
        assertEquals(5, ms.countExcept("barack"));
        assertEquals(4, ms.countExcept("citrom"));
    }
}
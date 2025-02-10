package data.structure;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

public class MultiSetTest{
    @Test
    public void multiSetInteger(){
        MultiSet<Integer> msi = new MultiSet<>();
        for (int i = 0; i < 100; i++){
            msi.add(i);
        }
        msi.add(12);
        msi.add(13);
        msi.add(14);
        msi.add(12);
        msi.add(12);

        assertEquals(1, msi.getCount(0));
        assertEquals(0, msi.getCount(-20));
        assertEquals(1, msi.getCount(20));
        assertEquals(4, msi.getCount(12));
        assertEquals(2, msi.getCount(13));
        assertEquals(2, msi.getCount(14));
    }

    @Test
    public void multiSetString(){
        MultiSet<String> mss = new MultiSet<>();
        mss.add("Hello");
        mss.add("World!");
        mss.add("James");
        mss.add("James");


        assertEquals(0, mss.getCount("World"));
        assertEquals(0, mss.getCount("hello"));
        assertEquals(1, mss.getCount("Hello"));
        assertEquals(1, mss.getCount("World!"));
        assertEquals(2, mss.getCount("James"));
    }

    @Test
    public void intersect(){
        MultiSet<Integer> ms1 = new MultiSet<>();
        MultiSet<Integer> ms2 = new MultiSet<>();
        /* 1: 0, 0, 1, 1, 1, 2, 2, 3 */
        /* 2: 0, 1, 1, 1, 1, 2, 2 */

        /* i: 0, 1, 1, 1, 2, 2 */
        ms1.add(0); ms1.add(0);
        ms1.add(1); ms1.add(1); ms1.add(1);
        ms1.add(2); ms1.add(2);
        ms1.add(3);
        
        ms2.add(0);
        ms2.add(1); ms2.add(1); ms2.add(1); ms2.add(1);
        ms2.add(2); ms2.add(2);

        MultiSet<Integer> intersection1 = ms1.intersect(ms2);
        MultiSet<Integer> intersection2 = ms2.intersect(ms1);
        
        assertEquals(1, intersection1.getCount(0));
        assertEquals(3, intersection1.getCount(1));
        assertEquals(2, intersection1.getCount(2));
        assertEquals(0, intersection1.getCount(3));

        assertEquals(1, intersection2.getCount(0));
        assertEquals(3, intersection2.getCount(1));
        assertEquals(2, intersection2.getCount(2));
        assertEquals(0, intersection2.getCount(3));
    }

    @Test
    public void countExcept(){
        MultiSet<Integer> ms = new MultiSet<>();
        for (int i = 0; i < 21; i++){
            for (int j = 0; j < i; j++){
                ms.add(i);
            }
        }

        assertEquals(210, ms.size());
        assertEquals(190, ms.countExcept(20));
        assertEquals(210, ms.countExcept(0));
    }
}
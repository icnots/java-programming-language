package loop;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;



import loop.iterator.GoAroundIterator;

public class GoAroundTest {
    @Test
    public void test() {
        GoAround<Integer> ga = new GoAround<>(2, 1, 2, 3, 4);
        GoAroundIterator<Integer> it = ga.iterator();
        assertTrue(it.hasNext());
        assertEquals(1, it.next());
        assertTrue(it.hasNext());
        assertEquals(2, it.next());
        assertTrue(it.hasNext());
        assertEquals(3, it.next());
        assertTrue(it.hasNext());
        assertEquals(4, it.next());

        assertTrue(it.hasNext());
        assertEquals(1, it.next());
        assertTrue(it.hasNext());
        assertEquals(2, it.next());
        assertTrue(it.hasNext());
        assertEquals(3, it.next());
        assertTrue(it.hasNext());
        assertEquals(4, it.next());

        assertFalse(it.hasNext());
    }

    @Test
    public void testMany(){
        GoAround<Integer> ga = new GoAround<>(10000, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int counter = 0;
        for (Integer i : ga){
            counter++;
        }

        assertEquals(100000, counter);
    }
}
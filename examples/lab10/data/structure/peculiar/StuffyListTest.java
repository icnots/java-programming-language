package data.structure.peculiar;


import static org.junit.Assert.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class StuffyListTest {
    @Test
    public void test1() {
        StuffyList<Integer> stuffyList = new StuffyList<>(123);
        stuffyList.add(new HashSet<>());

        assertEquals(List.of(123), stuffyList);
    }

    @Test
    public void test2() {
        StuffyList<Integer> stuffyList = new StuffyList<>(123);
        HashSet<Integer> set = new HashSet<>();
        set.add(123);
        stuffyList.add(set);

        assertEquals(List.of(123), stuffyList);
    }

    @Test
    public void test456() {
        StuffyList<Integer> stuffyList = new StuffyList<>(123);
        HashSet<Integer> set = new HashSet<>();
        set.add(456);
        set.add(789);
        stuffyList.add(set);

        HashSet<Integer> set2 = new HashSet<>();
        set2.add(10000);
        set2.add(-10000);
        stuffyList.add(set2);

        assertEquals(List.of(789, 456, 123, 10000, 123, -10000), stuffyList);
    }
}
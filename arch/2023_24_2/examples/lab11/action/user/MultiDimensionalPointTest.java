package action.user;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;


public class MultiDimensionalPointTest {
    @Test
    public void testInitUndo() {
        MultiDimensionalPoint mdp = new MultiDimensionalPoint(1, 2, 3);
        assertEquals(1, mdp.get(0));
        assertEquals(2, mdp.get(1));
        assertEquals(3, mdp.get(2));

        mdp.undoLast();
        assertEquals(1, mdp.get(0));
        assertEquals(2, mdp.get(1));
        assertEquals(3, mdp.get(2));
    }

    @Test
    public void testSetUndo() {
        MultiDimensionalPoint mdp = new MultiDimensionalPoint(1, 2, 3);

        mdp.set(2, 5);
        assertEquals(1, mdp.get(0));
        assertEquals(2, mdp.get(1));
        assertEquals(5, mdp.get(2));

        mdp.undoLast();
        assertEquals(1, mdp.get(0));
        assertEquals(2, mdp.get(1));
        assertEquals(3, mdp.get(2));

        mdp.undoLast();
        assertEquals(1, mdp.get(0));
        assertEquals(2, mdp.get(1));
        assertEquals(5, mdp.get(2));
    }

    @Test
    public void testScaleUndo() {
        MultiDimensionalPoint mdp = new MultiDimensionalPoint(1, 2, 3);

        mdp.scale(3);
        assertEquals(3, mdp.get(0));
        assertEquals(6, mdp.get(1));
        assertEquals(9, mdp.get(2));

        mdp.undoLast();
        assertEquals(1, mdp.get(0));
        assertEquals(2, mdp.get(1));
        assertEquals(3, mdp.get(2));

        mdp.undoLast();
        assertEquals(3, mdp.get(0));
        assertEquals(6, mdp.get(1));
        assertEquals(9, mdp.get(2));
    }

    @Test
    public void testEquality() {
        List<MultiDimensionalPoint> list1 = List.of(
            new MultiDimensionalPoint(),
            new MultiDimensionalPoint(1, 2, 3),
            new MultiDimensionalPoint(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        );

        List<MultiDimensionalPoint> list2 = List.of(
            new MultiDimensionalPoint(),
            new MultiDimensionalPoint(1, 2, 3),
            new MultiDimensionalPoint(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        );
        
        assertEquals(list2, list1);

        Set<Integer> hashCodes = Set.of(
            list1.get(0).hashCode(),
            list1.get(1).hashCode(),
            list1.get(2).hashCode()
        );
        
        assertEquals(3, hashCodes.size());
    }

    @Test
    public void testOrdering() {
        MultiDimensionalPoint p1 = new MultiDimensionalPoint();
        MultiDimensionalPoint p21 = new MultiDimensionalPoint(1, 2, 2);
        MultiDimensionalPoint p22 = new MultiDimensionalPoint(1, 2, 3);
        MultiDimensionalPoint p23 = new MultiDimensionalPoint(1, 2, 4);
        MultiDimensionalPoint p24 = new MultiDimensionalPoint(1, 4, 2);
        MultiDimensionalPoint p25 = new MultiDimensionalPoint(1, 4, 3);
        MultiDimensionalPoint p26 = new MultiDimensionalPoint(1, 4, 4);
        MultiDimensionalPoint p27 = new MultiDimensionalPoint(3, 4, 2);
        MultiDimensionalPoint p28 = new MultiDimensionalPoint(3, 4, 3);
        MultiDimensionalPoint p29 = new MultiDimensionalPoint(3, 4, 4);
        MultiDimensionalPoint p3 = new MultiDimensionalPoint(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<MultiDimensionalPoint> points = new ArrayList<>();
        points.add(p1);
        points.add(p21);
        points.add(p22);
        points.add(p23);
        points.add(p24);
        points.add(p25);
        points.add(p26);
        points.add(p27);
        points.add(p28);
        points.add(p29);
        points.add(p3);
        
        Collections.shuffle(points);
        Collections.sort(points);
        
        assertEquals(List.of(p1, p21, p22, p23, p24, p25, p26, p27, p28, p29, p3), points);
    }
}
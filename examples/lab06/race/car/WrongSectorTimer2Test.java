package race.car;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;


public class WrongSectorTimer2Test {
    @Test
    public void seemsGood(){
        int[] params = new int[]{1, 2, 3};
        WrongSectorTimer2 timer = new WrongSectorTimer2(params);

        int[] expected = new int[]{1, 2, 3};

        assertArrayEquals(expected, timer.getSectorTimes());
    }

    @Test
    public void constructorBreaksEncapsulation(){
        int[] params = new int[]{1, 2, 3};
        WrongSectorTimer2 timer = new WrongSectorTimer2(params);

        params[2] = 5;
        assertEquals(params.length, timer.getSectorTimes().length);
        // Feladat:
        // Ellenőrzendő: a timer.getSectorTimes() és timer.getSectorTime() eredményeként viszont így más eredmény adódik.
        // Inkább ellenőrizzük azt, hogy tényleg megváltozott-e a belső állapota
        assertArrayEquals(params, timer.getSectorTimes());
    }

    @Test
    public void getterBreaksEncapsulation(){
        int[] params = new int[]{1, 2, 3};
        WrongSectorTimer2 timer = new WrongSectorTimer2(params);

        timer.getSectorTimes()[1] = 3;
        int[] expected = new int[]{1, 3, 3};
        assertEquals(params.length, timer.getSectorTimes().length);
        assertArrayEquals(expected, timer.getSectorTimes());
    }

    @Test
    public void setterBreaksEncapsulation(){
        int[] params = new int[]{1, 2, 3};
        WrongSectorTimer2 timer = new WrongSectorTimer2(params);

        int[] other = new int[]{4, 5, 6, 7};
        timer.setSectorTimes(other);
        other[2] = 1;

        int[] expected = new int[]{4, 5, 1, 7};
        assertNotEquals(params.length, timer.getSectorTimes().length);
        assertArrayEquals(expected, timer.getSectorTimes());
    }
}
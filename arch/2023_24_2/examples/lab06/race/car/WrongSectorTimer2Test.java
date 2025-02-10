package race.car;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;


public class WrongSectorTimer2Test{
    private WrongSectorTimer2 it;

    @BeforeEach
    public void init(){
        it = new WrongSectorTimer2(new int[]{1, 2, 3});
    }

    @Test
    public void seemsGood(){
        int[] expected = new int[]{1, 2, 3};
        assertArrayEquals(expected, it.getSectorTimes());
    }

    @Test
    public void constructorBreaksEncapsulation(){
        int[] local = new int[]{1, 4, 5};

        WrongSectorTimer2 timer = new WrongSectorTimer2(local);

        local[0] = 3;

        assertArrayEquals(local, timer.getSectorTimes());
    }

    @Test
    public void getterBreaksEncapsulation(){
        it.getSectorTimes()[0] = 4;

        int[] expected = new int[]{4, 2, 3};

        assertArrayEquals(expected, it.getSectorTimes());
    }

    @Test
    public void setterBreaksEncapsulation(){
        int[] local = new int[]{4, 5, 6, 7};

        it.setSectorTimes(local);
        local[1] = 8;

        assertArrayEquals(local, it.getSectorTimes());
    }
}
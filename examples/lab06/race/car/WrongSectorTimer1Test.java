package race.car;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;


public class WrongSectorTimer1Test{
    private WrongSectorTimer1 it;

    @BeforeEach
    public void init(){
        it = new WrongSectorTimer1(new int[]{1, 2, 3});
    }

    @Test
    public void seemsGood(){
        int[] expected = new int[]{1, 2, 3};
        assertArrayEquals(expected, it.sectorTimes);
    }

    @Test
    public void setArrayElemsBreaksEncapsulation1(){
        it.sectorTimes[2] = 5;
        int[] expected = new int[]{1, 2, 5};
        assertArrayEquals(expected, it.sectorTimes);
    }

    @Test
    public void setArrayElemsBreaksEncapsulation2(){
        it.sectorTimes = new int[]{1, 3, 5, 7};
        int[] expected = new int[]{1, 3, 5, 7};
        assertArrayEquals(expected, it.sectorTimes);
    }
}
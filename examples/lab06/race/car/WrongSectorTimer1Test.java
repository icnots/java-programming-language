package race.car;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;


public class WrongSectorTimer1Test {
    WrongSectorTimer1 it;

    @BeforeEach
    public void initialize(){
        int[] param = new int[]{1, 2, 3};
        it = new WrongSectorTimer1(param);
    }

    @Test
    public void seemsGood(){
        int[] expected = new int[]{1, 2, 3};
        assertArrayEquals(expected, it.sectorTimes);
    }

    @Test
    public void setArrayElemsBreaksEncapsulation1(){
        int[] expected = new int[]{1, 2, 5};
        it.sectorTimes[2] = 5;
        assertArrayEquals(expected, it.sectorTimes);
    }

    @Test
    public void setArrayElemsBreaksEncapsulation2(){
        int[] expected = new int[]{6, 7, 8, 9};
        it.sectorTimes = expected.clone();

        assertArrayEquals(expected, it.sectorTimes);
    }
}
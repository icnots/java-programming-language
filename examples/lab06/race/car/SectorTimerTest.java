package race.car;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;


public class SectorTimerTest {
    @Test
    public void constructorEncapsulatesWell(){
        int[] params = new int[]{1, 2, 3};
        int[] expected = params.clone();
        SectorTimer timer = new SectorTimer(params);

        params[2] = 5;
        assertArrayEquals(expected, timer.getSectorTimes());
    }

    @Test
    public void getterEncapsulatesWell(){
        int[] params = new int[]{1, 2, 3};
        int[] expected = params.clone();
        SectorTimer timer = new SectorTimer(params);

        timer.getSectorTimes()[2] = 5;
        assertArrayEquals(expected, timer.getSectorTimes());
    }

    @Test
    public void setterEncapsulatesWell(){
        int[] params = new int[]{1, 2, 3};
        int[] other = new int[]{4, 5, 6, 7};
        int[] expected = other.clone();
        SectorTimer timer = new SectorTimer(params);

        timer.setSectorTimes(other);
        other[2] = 1;
        assertArrayEquals(expected, timer.getSectorTimes());
    }
    
}
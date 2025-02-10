package race.car;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;


public class SectorTimerTest{
    @Test
    public void constructorEncapsulatesWell(){
        int[] initialArray = new int[]{1, 2, 3};
        SectorTimer it = new SectorTimer(initialArray);

        initialArray[2] = 11;
        int[] expected = new int[]{1, 2, 3};
        
        assertArrayEquals(expected, it.getSectorTimesV2());
        assertArrayEquals(expected, it.getSectorTimes());
    }

    @Test
    public void getterEncapsulatesWell(){
        int[] initialArray = new int[]{1, 2, 3};
        SectorTimer it = new SectorTimer(initialArray);
        int[] modifiableArray = it.getSectorTimesV2();

        modifiableArray[1] = 4;

        int[] expected = new int[]{1, 2, 3};
        assertArrayEquals(expected, it.getSectorTimesV2());
        assertArrayEquals(expected, it.getSectorTimes());
    }

    @Test
    public void setterEncapsulatesWell(){
        int[] initialArray = new int[]{1, 2, 3};
        SectorTimer it = new SectorTimer(initialArray);

        initialArray[0] = 0;
        it.setSectorTimesV2(initialArray);

        int[] expected = new int[]{0, 2, 3};
        assertArrayEquals(expected, it.getSectorTimesV2());
        assertArrayEquals(expected, it.getSectorTimes());
    }
}
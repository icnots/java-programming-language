package array.util;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

public class ArrayUtilTest{
    @Test
    public void maxLength0(){
        assertEquals(0, ArrayUtil.max(new int[0]));
        assertEquals(0, ArrayUtil.max2(new int[0]));
        assertEquals(0, ArrayUtil.max3(new int[0]));
        assertEquals(0, ArrayUtil.max4(new int[0]));
    }

    @ParameterizedTest(name = "max of [{0}] is {0}")
    @CsvSource(textBlock = """
        1,
        3,
        -8
    """)
    public void maxLength1(int maxValue){
        assertEquals(maxValue, ArrayUtil.max(new int[]{maxValue}));
        assertEquals(maxValue, ArrayUtil.max2(new int[]{maxValue}));
        assertEquals(maxValue, ArrayUtil.max3(new int[]{maxValue}));
        assertEquals(maxValue, ArrayUtil.max4(new int[]{maxValue}));
    }

    @ParameterizedTest(name = "max of both [{0}, {1}] and [{1}, {0}] is {1}")
    @CsvSource(textBlock = """
        1, 2
        3, 180
        -8, -3
        -256, 128
    """)
    public void maxLength1(int minValue, int maxValue){
        assertEquals(maxValue, ArrayUtil.max(new int[]{minValue, maxValue}));
        assertEquals(maxValue, ArrayUtil.max2(new int[]{minValue, maxValue}));
        assertEquals(maxValue, ArrayUtil.max3(new int[]{minValue, maxValue}));
        assertEquals(maxValue, ArrayUtil.max4(new int[]{minValue, maxValue}));

        assertEquals(maxValue, ArrayUtil.max (new int[]{maxValue, minValue}));
        assertEquals(maxValue, ArrayUtil.max2(new int[]{maxValue, minValue}));
        assertEquals(maxValue, ArrayUtil.max3(new int[]{maxValue, minValue}));
        assertEquals(maxValue, ArrayUtil.max4(new int[]{maxValue, minValue}));
    }

    @Test
    public void minMaxLength0(){
        int[] expected = new int[]{0, 0};
        assertArrayEquals(expected, ArrayUtil.minMax(new int[0]));
    }

    @ParameterizedTest(name = "min, max of [{0}] is [{0}, {0}]")
    @CsvSource(textBlock = """
        1,
        3,
        -8
    """)
    public void minMaxLength1(int value){
        int[] expected = new int[]{value, value};
        assertArrayEquals(expected, ArrayUtil.minMax(new int[]{value}));
    }

    @ParameterizedTest(name = "min, max of both [{0}, {1}] and [{1}, {0}] is [{0},{1}]")
    @CsvSource(textBlock = """
        1, 2
        3, 180
        -8, -3
        -256, 128
    """)
    public void minMaxLenght2(int minValue, int maxValue){
        int[] expected = new int[]{minValue, maxValue};
        assertArrayEquals(expected, ArrayUtil.minMax(new int[]{minValue, maxValue}));
        assertArrayEquals(expected, ArrayUtil.minMax(new int[]{maxValue, minValue}));
    }
}
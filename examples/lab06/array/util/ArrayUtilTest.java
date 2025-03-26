package array.util;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;


public class ArrayUtilTest {
    @Test
    public void maxLength0() {
        int[] emptyArray = new int[0];
        assertEquals(0, ArrayUtil.max(emptyArray));
        assertEquals(0, ArrayUtil.max2(emptyArray));
        assertEquals(0, ArrayUtil.max3(emptyArray));
        assertEquals(0, ArrayUtil.max4(emptyArray));
    }

    @ParameterizedTest(name = "max([{0}]) is {0}")
    @CsvSource(textBlock = """
        0
        1
        -12345
        98765
    """)
    @DisableIfHasBadStructure
    public void maxLength1(int number){
        int[] oneElementArray = new int[]{number};
        assertEquals(number, ArrayUtil.max(oneElementArray));
        assertEquals(number, ArrayUtil.max2(oneElementArray));
        assertEquals(number, ArrayUtil.max3(oneElementArray));
        assertEquals(number, ArrayUtil.max4(oneElementArray));
    }

    @ParameterizedTest(name = "max([{0}, {1}]) is {2}")
    @CsvSource(textBlock = """
        0, 2, 2
        -123, -500, -123
        987, 1001, 1001
        -100, 200, 200
        -987656, 0, 0
    """)
    @DisableIfHasBadStructure
    public void maxLength2(int n1, int n2, int expected){
        int[] twoElementArray = new int[]{n1, n2};
        assertEquals(expected, ArrayUtil.max(twoElementArray));
        assertEquals(expected, ArrayUtil.max2(twoElementArray));
        assertEquals(expected, ArrayUtil.max3(twoElementArray));
        assertEquals(expected, ArrayUtil.max4(twoElementArray));

        twoElementArray = new int[]{n2, n1};
        assertEquals(expected, ArrayUtil.max(twoElementArray));
        assertEquals(expected, ArrayUtil.max2(twoElementArray));
        assertEquals(expected, ArrayUtil.max3(twoElementArray));
        assertEquals(expected, ArrayUtil.max4(twoElementArray));
    }

    @ParameterizedTest(name = "max([{1}]) is {0}")
    @CsvSource(textBlock = """
        4, '1, 2, 3, 4'
        0, '-100, -9876, -567, 0, -123, -43'
    """)
    @DisableIfHasBadStructure
    public void testGeneral(int expected, String numbersAsString) {
        String[] numbersAsStrings = numbersAsString.split(", ");
        int n = numbersAsStrings.length;
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++){
            numbers[i] = Integer.parseInt(numbersAsStrings[i]);
        }
        
        assertEquals(expected, ArrayUtil.max(numbers));
        assertEquals(expected, ArrayUtil.max2(numbers));
        assertEquals(expected, ArrayUtil.max3(numbers));
        assertEquals(expected, ArrayUtil.max4(numbers));
    }

    @Test
    public void minMaxLength0() {
        int[] expected = new int[]{0, 0};
        int[] emptyArray = new int[0];
        assertArrayEquals(expected, ArrayUtil.minMax(emptyArray));
    }

    @ParameterizedTest(name = "minMax([{0}]) is [{0}, {0}]")
    @CsvSource(textBlock = """
        0
        1
        -12345
        98765
    """)
    @DisableIfHasBadStructure
    public void minMaxLength1(int number){
        int[] expected = new int[]{number, number};
        int[] oneElementArray = new int[]{number};
        assertArrayEquals(expected, ArrayUtil.minMax(oneElementArray));
    }

    // Here the two values are expected to be in non-descending order
    @ParameterizedTest(name = "minMax([{0},{1}])=minMax([{1},{0}]) =?= [{0}, {1}]")
    @CsvSource(textBlock = """
        0, 2
        -123, -500
        987, 1001
        -100, 200
        -987656, 0
        33, 33
    """)
    @DisableIfHasBadStructure
    public void minMaxLength2(int n1, int n2){
        int[] expected = new int[]{Math.min(n1, n2), Math.max(n1, n2)};
        int[] twoElementArray = new int[]{n1, n2};
        assertArrayEquals(expected, ArrayUtil.minMax(twoElementArray));

        twoElementArray = new int[]{n2, n1};
        assertArrayEquals(expected, ArrayUtil.minMax(twoElementArray));
    }
}
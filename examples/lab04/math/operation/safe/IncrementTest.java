package math.operation.safe;

/*
  Ez a másik package-beli tesztfájl!
*/

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

import math.operation.safe.Increment;

public class IncrementTest {
    @Test
    public void testZero() {
        assertEquals(1, Increment.increment(0));
    }

    @Test
    public void testMaxValue() {
        int maxValue = Integer.MAX_VALUE;
        assertEquals(maxValue, Increment.increment(maxValue));
    }

    @Test
    public void testMinValue() {
        int minValue = Integer.MIN_VALUE;
        assertEquals(minValue+1, Increment.increment(minValue));
    }

    @ParameterizedTest(name = "Increment of {0} is {1}?")
    @CsvSource(textBlock = """
        1, 2
        -1, 0
        1234, 1235
        -10000, -9999
    """)
    @DisableIfHasBadStructure
    public void testWithParameters(int value, int expected) {
        assertEquals(expected, Increment.increment(value));
    }
}

package famous.sequence;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

public class TriangularNumbersTest {
    @Test
    public void testZero() {
        assertEquals(0, TriangularNumbers.getTriangularNumber(0));
    }

    @Test
    public void testHundred() {
        assertEquals(5050, TriangularNumbers.getTriangularNumber(100));
    }



    @ParameterizedTest(name = "parameterized test : triangular({1}) =?= {0} ")
    @CsvSource(textBlock = """
        3, 2
        6, 3
        10, 4
        0, -5
        0, -1
        0, 0
    """)
    @DisableIfHasBadStructure
    public void testParameterizedForTriangularNumbers(int expected, int n) {
        assertEquals(expected, TriangularNumbers.getTriangularNumber(n));
    }
}

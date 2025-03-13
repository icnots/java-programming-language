package math.operation.textual;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;

public class AdderTest {
    @ParameterizedTest(name = "Wrong input: {0} + {1}")
    @CsvSource(textBlock = """
        two, one
        hundred, 100
        100, hundred
    """)
    @DisableIfHasBadStructure
    public void wrongInput(String lhs, String rhs) {
        Adder adder = new Adder();
        assertEquals("Operands are not numbers", adder.addAsText(lhs, rhs));
    }

    @ParameterizedTest(name = "Adding zero: {0} + {1} =?= {2}")
    @CsvSource(textBlock = """
        -123, 0, -123
        -123, 0.0, -123.0
        0, 999, 999
        0.0, 999, 999.0
        0.0, 0, 0.0
        0, 0.0, 0.0
    """)
    @DisableIfHasBadStructure
    public void addZero(String lhs, String rhs, String expected) {
        Adder adder = new Adder();
        assertEquals(expected, adder.addAsText(lhs, rhs));
    }

    @ParameterizedTest(name = "Add is working: {0} + {1} =?= {2}")
    @CsvSource(textBlock = """
        -10, 90, 80
        10.0, -90.0, -80.0
        1000, -1.0, 999.0
    """)
    @DisableIfHasBadStructure
    public void add(String lhs, String rhs, String expected) {
        Adder adder = new Adder();
        assertEquals(expected, adder.addAsText(lhs, rhs));
        assertEquals(expected, adder.addAsText(rhs, lhs));
    }
    
    @ParameterizedTest(name = "Add is commutative: {0} + {1} =?= {1} + {0}")
    @CsvSource(textBlock = """
        -10, 90
        10.0, -90.0
        1000, -1.0
        -29.17, 13.77
    """)
    @DisableIfHasBadStructure
    public void addCommutative(String lhs, String rhs) {
        Adder adder = new Adder();
        assertEquals(adder.addAsText(lhs, rhs), adder.addAsText(rhs, lhs));
    }

/*
    @Test
    public void wrongInput() {
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
*/
}

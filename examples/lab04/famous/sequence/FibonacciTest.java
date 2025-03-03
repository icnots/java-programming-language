package famous.sequence;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;


public class FibonacciTest {
    @Test
    public void testFib5() {
        assertEquals(5, famous.sequence.Fibonacci.fib(5));
    }
    
    @Test
    public void testFib10() {
        assertEquals(55, famous.sequence.Fibonacci.fib(10));
    }

    @ParameterizedTest(name = "fib({0})+fib({1}) =?= fib({2})")
    @CsvSource(textBlock = """
        0, 1, 2
        1, 2, 3
        2, 3, 4
    """)
    @DisableIfHasBadStructure
    public void testRecursivity(int fst, int snd, int trd) {
        int fFst = Fibonacci.fib(fst);
        int fSnd = Fibonacci.fib(snd);
        int fTrd = Fibonacci.fib(trd);

        assertEquals(fTrd, fFst + fSnd);
    }
}

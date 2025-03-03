import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class TriangularNumbersStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("famous.sequence.TriangularNumbers")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void constructor() {
        it.has(DEFAULT_CONSTRUCTOR);
    }

    @Test
    public void methodGetTriangularNumber() {
        it.hasMethod("getTriangularNumber", withParams("n: int"))
            .thatIs(FULLY_IMPLEMENTED, USABLE_WITHOUT_INSTANCE, VISIBLE_TO_ALL)
            .thatReturns("int");
    }

    @Test
    public void methodGetTriangularNumberAlternative() {
        it.hasMethod("getTriangularNumberAlternative", withParams("n: int"))
            .thatIs(FULLY_IMPLEMENTED, USABLE_WITHOUT_INSTANCE, VISIBLE_TO_ALL)
            .thatReturns("int");
    }
}


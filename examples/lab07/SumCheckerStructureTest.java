import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class SumCheckerStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("file.line.SumChecker")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void constructor() {
        it.has(DEFAULT_CONSTRUCTOR);
    }

    @Test
    public void methodGetNumbers() {
        it.hasMethod("getNumbers", withParams("String"))
            .thatIs(FULLY_IMPLEMENTED, USABLE_WITHOUT_INSTANCE, VISIBLE_TO_NONE)
            .thatReturns("array of int");
    }

    @Test
    public void methodMain() {
        it.hasMethod("main", withParams("array of String"))
            .thatIs(FULLY_IMPLEMENTED, USABLE_WITHOUT_INSTANCE, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }
}


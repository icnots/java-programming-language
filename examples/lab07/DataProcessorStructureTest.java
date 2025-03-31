import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class DataProcessorStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("text.to.numbers.DataProcessor")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void constructor() {
        it.has(DEFAULT_CONSTRUCTOR);
    }

    @Test
    public void methodConvert() {
        it.hasMethod("convert", withParams("array of String"))
            .thatIs(FULLY_IMPLEMENTED, USABLE_WITHOUT_INSTANCE, VISIBLE_TO_ALL)
            .thatReturns("array of int");
    }

    @Test
    public void methodConvertWithDefault() {
        it.hasMethod("convertWithDefault", withParams("int", "array of String"))
            .thatIs(FULLY_IMPLEMENTED, USABLE_WITHOUT_INSTANCE, VISIBLE_TO_ALL)
            .thatReturns("array of int");
    }

    @Test
    public void methodCountFileLines() {
        it.hasMethod("countFileLines", withParams("String"))
            .thatIs(FULLY_IMPLEMENTED, USABLE_WITHOUT_INSTANCE, VISIBLE_TO_ALL)
            .thatReturns("int");
    }

    @Test
    public void methodMain() {
        it.hasMethod("main", withParams("array of String"))
            .thatIs(FULLY_IMPLEMENTED, USABLE_WITHOUT_INSTANCE, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

    @Test
    public void methodSumFile() {
        it.hasMethod("sumFile", withParams("String", "String"))
            .thatIs(FULLY_IMPLEMENTED, USABLE_WITHOUT_INSTANCE, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }
}


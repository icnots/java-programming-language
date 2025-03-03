import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class AdderStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("math.operation.textual.Adder")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void constructor() {
        it.has(DEFAULT_CONSTRUCTOR);
    }

    @Test
    public void methodAddAsText() {
        it.hasMethod("addAsText", withParams("opTxt1: String", "opTxt2: String"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("String");
    }
}


import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class IncrementStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("math.operation.safe.Increment")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void constructor() {
        it.has(DEFAULT_CONSTRUCTOR);
    }

    @Test
    public void methodIncrement() {
        it.hasMethod("increment", withParams("int"))
            .thatIs(FULLY_IMPLEMENTED, USABLE_WITHOUT_INSTANCE, VISIBLE_TO_ALL)
            .thatReturns("int");
    }
}


import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class SoliloquyStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("magic.Soliloquy")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void constructor() {
        it.has(DEFAULT_CONSTRUCTOR);
    }

    @Test
    public void methodMain() {
        it.hasMethod("main", withParams("array of String"))
            .thatIs(FULLY_IMPLEMENTED, USABLE_WITHOUT_INSTANCE, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

    @Test
    public void methodPrintStatus() {
        it.hasMethod("printStatus", withParams("boolean", "magic.library.Incantation", "magic.library.Incantation"))
            .thatIs(FULLY_IMPLEMENTED, USABLE_WITHOUT_INSTANCE, VISIBLE_TO_NONE)
            .thatReturnsNothing();
    }

    @Test
    public void methodReciteIncantations() {
        it.hasMethod("reciteIncantations", withParams("magic.library.Incantation", "magic.library.Incantation", "int", "boolean"))
            .thatIs(FULLY_IMPLEMENTED, USABLE_WITHOUT_INSTANCE, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }
}


import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class ScalableStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theInterface("action.Scalable")
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    public void methodScale() {
        it.hasMethod("scale", withParams("int"))
            .thatIs(NOT_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }
}


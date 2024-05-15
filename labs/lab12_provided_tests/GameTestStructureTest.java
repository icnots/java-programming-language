import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class GameTestStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("uno.GameTest")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void noArgTestMethods() {
        it.hasNoArgTestMethods(
            "test"
        );
    }
}


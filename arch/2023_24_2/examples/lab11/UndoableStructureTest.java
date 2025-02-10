import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class UndoableStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theInterface("action.Undoable")
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    public void methodUndoLast() {
        it.hasMethod("undoLast", withNoParams())
            .thatIs(NOT_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }
}


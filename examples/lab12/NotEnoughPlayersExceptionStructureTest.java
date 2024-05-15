import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class NotEnoughPlayersExceptionStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theCheckedException("uno.util.NotEnoughPlayersException")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void constructor() {
        it.hasConstructor(withArgs("int"))
            .thatIs(VISIBLE_TO_ALL);
    }
}


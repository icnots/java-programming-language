package cafe;

import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class AdultStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("cafe.Adult", withParent("cafe.Guest"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void constructor() {
        it.hasConstructor(withArgs("String", "int"))
            .thatIs(VISIBLE_TO_ALL);
    }
}


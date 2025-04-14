package cafe;

import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class BartenderStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("cafe.Bartender")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void fieldLegalAge() {
        it.hasField("legalAge: int")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    public void constructor() {
        it.hasConstructor(withArgs("int"))
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    public void methodOrder() {
        it.hasMethod("order", withParams("Guest"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("boolean");
    }
}


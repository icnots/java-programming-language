package cafe;

import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class GuestStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("cafe.Guest")
            .thatIs(NOT_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void fieldName() {
        it.hasField("name: String")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_SUBCLASSES)
            .thatHas(GETTER)
            .thatHasNo(SETTER);
    }

    @Test
    public void fieldAge() {
        it.hasField("age: int")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_SUBCLASSES)
            .thatHas(GETTER)
            .thatHasNo(SETTER);
    }

    @Test
    public void constructor() {
        it.hasConstructor(withArgs("String", "int"))
            .thatIs(VISIBLE_TO_ALL);
    }
}


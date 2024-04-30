import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class GoAroundStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("loop.GoAround", withInterface("Iterable"))
            .withTypeParameter("T")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void fieldRoundCount() {
        it.hasField("roundCount: int")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    public void fieldElements() {
        it.hasField("elements: List of T")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    public void constructor() {
        it.hasConstructor(withArgs("int", "vararg of T"))
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    public void methodIterator() {
        it.hasMethod("iterator", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("loop.iterator.GoAroundIterator of T");
    }
}

import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import check.CheckThat;

public class OrganiserStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("data.organiser.Organiser")
            .withTypeParameter("T")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void fieldElems() {
        it.hasField("elems: ArrayList of T")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHasNo(GETTER, SETTER);
    }

    //@Test
    //public void fieldSwaps() {
    //    it.hasField("swaps: ArrayList of T")
    //        .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
    //        .thatHasNo(GETTER, SETTER);
    //}

    @Test
    public void fieldSwaps() {
        it.hasField("swaps: ArrayList of java.util.Map.Entry of Integer and Integer")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    public void constructor() {
        it.hasConstructor(withParams("vararg of T"))
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    public void methodAddSwap() {
        it.hasMethod("addSwap", withParams("int", "int"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

    @Test
    public void methodGet() {
        it.hasMethod("get", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("ArrayList of T");
    }

    @Test
    public void methodGetV2() {
        it.hasMethod("get", withParams("int"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("T");
    }

    @Test
    public void methodSwap() {
        it.hasMethod("swap", withParams("int", "int"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_NONE)
            .thatReturnsNothing();
    }

    @Test
    public void methodRunSwaps() {
        it.hasMethod("runSwaps", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

    @Test
    @DisabledIf(notApplicable)
    public void text() {
        it.has(TEXTUAL_REPRESENTATION);
    }
}

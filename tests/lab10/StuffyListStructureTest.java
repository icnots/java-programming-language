import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class StuffyListStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("data.structure.peculiar.StuffyList", withParent("java.util.ArrayList"))
            .withTypeParameter("E")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void fieldNeededElement() {
        it.hasField("neededElement: E")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    public void constructor() {
        it.hasConstructor(withArgs("E"))
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    public void methodAddV1() {
        it.hasMethod("add", withParams("HashSet of E"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("boolean");
    }

    @Test
    public void methodAddV2() {
        it.hasMethod("add", withParams("E"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("boolean");
    }
}

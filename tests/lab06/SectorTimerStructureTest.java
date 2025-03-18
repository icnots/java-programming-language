import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class SectorTimerStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("race.car.SectorTimer")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void fieldSectorTimes() {
        it.hasField("sectorTimes: array of int")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHas(GETTER)
            .thatHasNo(SETTER);
    }

    @Test
    public void constructor01() {
        it.hasConstructor(withParams("array of int"))
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    public void constructor02() {
        it.hasConstructor(withParams("boolean", "array of int"))
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    public void methodGetSectorTime() {
        it.hasMethod("getSectorTime", withParams("int"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("int");
    }

    @Test
    public void methodGetSectorTimesV2() {
        it.hasMethodWithNoParams("getSectorTimesV2")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("array of int");
    }

    @Test
    public void methodInitSectorTimes() {
        it.hasMethod("initSectorTimes", withParams("array of int"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_NONE)
            .thatReturnsNothing();
    }

    @Test
    public void methodSetLapTimes() {
        it.hasMethod("setLapTimes", withParams("array of int"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

    @Test
    public void methodSetSectorTimesV2() {
        it.hasMethod("setSectorTimesV2", withParams("array of int"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }
}


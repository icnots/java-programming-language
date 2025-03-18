
import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class LapTimerStructureTest {
    @Test
    public void fieldLapTimes() {
        CheckThat.theClass("race.car.LapTimer")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .hasField("lapTimes: vararg of int")
                .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
                .thatHas(GETTER, SETTER);
    }

    @Test
    public void constructor() {
        it.hasConstructor(withParams("vararg of int"))
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    public void methodGetLapTime() {
        it.hasMethod("getLapTime", withParams("int"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns(int.class);
    }

    @Test
    public void methodGetLapTimesV2() {
        it.hasMethodWithNoParams("getLapTimesV2")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("array of int");
    }

    @Test
    public void methodSetLapTimesV2() {
        it.hasMethod("setLapTimesV2", withParams("vararg of int"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

}


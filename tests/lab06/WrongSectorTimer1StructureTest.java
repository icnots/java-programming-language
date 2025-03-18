import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class WrongSectorTimer1StructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("race.car.WrongSectorTimer1")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void fieldSectorTimes() {
        it.hasField("sectorTimes: array of int")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_ALL)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    public void constructor() {
        it.hasConstructor(withParams("array of int"))
            .thatIs(VISIBLE_TO_ALL);
    }
}


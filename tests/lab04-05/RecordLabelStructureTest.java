import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import check.CheckThat;

@TestMethodOrder(OrderAnnotation.class)
public class RecordLabelStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("music.recording.RecordLabel")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test @Order(1_1)
    public void fieldName() {
        it.hasField("name: String")
            .thatIs(INSTANCE_LEVEL, NOT_MODIFIABLE, VISIBLE_TO_NONE)
            .thatHas(GETTER)
            .thatHasNo(SETTER);
    }

    @Test @Order(1_2)
    public void fieldCash() {
        it.hasField("cash: int")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHas(GETTER)
            .thatHasNo(SETTER);
    }

    @Test @Order(2_0)
    public void constructor() {
        it.hasConstructor(withArgsSimilarToFields())
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    public void methodGotIncome() {
        it.hasMethod("gotIncome", withParams("sum: int"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }
}


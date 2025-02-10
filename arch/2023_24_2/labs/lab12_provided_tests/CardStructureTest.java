import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIf;

import check.CheckThat;

public class CardStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("uno.util.Card")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatHas(EQUALITY_CHECK);
    }

    @Test
    public void fieldColor() {
        it.hasField("color: Color")
            .thatIs(INSTANCE_LEVEL, NOT_MODIFIABLE, VISIBLE_TO_ALL)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    public void fieldType() {
        it.hasField("type: CardType")
            .thatIs(INSTANCE_LEVEL, NOT_MODIFIABLE, VISIBLE_TO_ALL)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    public void fieldValue() {
        it.hasField("value: int")
            .thatIs(INSTANCE_LEVEL, NOT_MODIFIABLE, VISIBLE_TO_ALL)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    public void constructor() {
        it.hasConstructor(withArgs("Color", "CardType", "int"))
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    public void methodIsPlayableOver() {
        it.hasMethod("isPlayableOver", withParams("Card"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("boolean");
    }

    @Test
    @DisabledIf(notApplicable)
    public void text() {
        it.has(TEXTUAL_REPRESENTATION);
    }
}

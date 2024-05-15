import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIf;

import check.CheckThat;

public class PlayerStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("uno.Player")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void fieldName() {
        it.hasField("name: String")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHas(GETTER)
            .thatHasNo(SETTER);
    }

    @Test
    public void fieldHand() {
        it.hasField("hand: List of uno.util.Card")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHas(GETTER)
            .thatHasNo(SETTER);
    }

    @Test
    public void fieldGame() {
        it.hasField("game: Game")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    public void constructor() {
        it.hasConstructor(withArgs("String", "List of uno.util.Card", "Game"))
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    public void methodAddToHand() {
        it.hasMethod("addToHand", withParams("List of uno.util.Card"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

    @Test
    public void methodRemoveFromHand() {
        it.hasMethod("removeFromHand", withParams("int"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

    @Test
    @DisabledIf(notApplicable)
    public void text() {
        it.has(TEXTUAL_REPRESENTATION);
    }
}

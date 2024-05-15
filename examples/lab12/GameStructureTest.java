import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class GameStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("uno.Game")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void fieldDeck() {
        it.hasField("deck: LinkedList of uno.util.Card")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_PACKAGE)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    public void fieldPlayers() {
        it.hasField("players: List of Player")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_PACKAGE)
            .thatHas(GETTER)
            .thatHasNo(SETTER);
    }

    @Test
    public void fieldCurrentCard() {
        it.hasField("currentCard: uno.util.Card")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_PACKAGE)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    public void fieldCurrentPlayerIdx() {
        it.hasField("currentPlayerIdx: int")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_PACKAGE)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    public void fieldIsForward() {
        it.hasField("isForward: boolean")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_PACKAGE)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    public void fieldIsOn() {
        it.hasField("isOn: boolean")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_PACKAGE)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    public void fieldInputSource() {
        it.hasField("inputSource: uno.util.InputSource")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_PACKAGE)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    public void constructor() {
        it.hasConstructor(withArgs("int", "uno.util.InputSource", "vararg of String"))
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    public void methodInitDeck() {
        it.hasMethod("initDeck", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_NONE)
            .thatReturnsNothing();
    }

    @Test
    public void methodInitPlayers() {
        it.hasMethod("initPlayers", withParams("int", "vararg of String"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_NONE)
            .thatReturnsNothing();
    }

    @Test
    public void methodDrawCards() {
        it.hasMethod("drawCards", withParams("int"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_NONE)
            .thatReturns("List");
    }

    @Test
    public void methodMain() {
        it.hasMethod("main", withParams("array of String"))
            .thatIs(FULLY_IMPLEMENTED, USABLE_WITHOUT_INSTANCE, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

    @Test
    public void methodPlayNext() {
        it.hasMethod("playNext", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

    @Test
    public void methodGetNextPlayerIdx() {
        it.hasMethod("getNextPlayerIdx", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("int");
    }

    @Test
    public void methodCurrentPlayerDrawCard() {
        it.hasMethod("currentPlayerDrawCard", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_NONE)
            .thatReturnsNothing();
    }

    @Test
    public void methodGetCurrentPlayer() {
        it.hasMethod("getCurrentPlayer", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("Player");
    }


    @Test
    public void methodInteractiveMsg() {
        it.hasMethod("interactiveMsg", withParams("String"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_NONE)
            .thatReturnsNothing();
    }

    @Test
    public void methodUseCardEffect() {
        it.hasMethod("useCardEffect", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_NONE)
            .thatReturnsNothing();
    }
}


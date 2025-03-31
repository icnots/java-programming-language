import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class CharacterStatisticsStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("text.util.CharacterStatistics")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void constructor() {
        it.hasConstructor(withParams("String"))
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    public void text() {
    	it.has(TEXTUAL_REPRESENTATION);
    }

    @Test
    public void fieldCharToCount() {
        it.hasField("charToCount: HashMap of Character to Integer")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    public void methodGetCount() {
        it.hasMethod("getCount", withParams("char"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("int");
    }
}

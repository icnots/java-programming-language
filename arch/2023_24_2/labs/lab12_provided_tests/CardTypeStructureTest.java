import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class CardTypeStructureTest {
    @Test
    public void testEnum() {
        CheckThat.theEnum("uno.util.CardType")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .hasEnumElements("VALUE", "REVERSE", "SKIP", "TAKE");
    }
}


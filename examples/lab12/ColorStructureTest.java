import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class ColorStructureTest {
    @Test
    public void testEnum() {
        CheckThat.theEnum("uno.util.Color")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .hasEnumElements("GREEN", "BLUE", "YELLOW", "RED");
    }
}


import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.MethodOrderer.*;
import check.*;

@TestMethodOrder(OrderAnnotation.class)
public class CategoryStructureTest {
    @Test
    public void init() {
        CheckThat.theEnum("iot.device.Category")
                 .hasEnumElements("LIGHT", "LED_STRIP", "TV", "FRIDGE", "COFFEE_MACHINE");
    }
}
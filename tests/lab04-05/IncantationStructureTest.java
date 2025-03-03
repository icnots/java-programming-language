import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import check.CheckThat;

@TestMethodOrder(OrderAnnotation.class)
public class IncantationStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("magic.library.Incantation")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test @Order(1_1)
    public void fieldText() {
        it.hasField("text: String")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHas(GETTER)
            .thatHasNo(SETTER);
    }

    @Test @Order(1_2)
    public void fieldIndex() {
        it.hasField("index: int")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHas(GETTER, SETTER);
    }

    @Test @Order(2_0)
    public void constructor01() {
        it.hasConstructor(withParams("other: Incantation"))
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test @Order(2_0)
    public void constructor02() {
        it.hasConstructor(withArgsSimilarToFields())
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    public void methodEnchant() {
        it.hasMethod("enchant", withParams("other: Incantation", "isPrepend: boolean"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("boolean");
    }
}


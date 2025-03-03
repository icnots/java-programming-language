import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import check.*;

@TestMethodOrder(OrderAnnotation.class)
public class CaesarCipherStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("cipher.CaesarCipher")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test @Order(1_1)
    @UsedInFunctionalTests({"noShift", "encryptBy"})
    public void fieldShift() {
        it.hasField("shift: int")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHasNo(GETTER, SETTER);
    }

    @Test @Order(2_0)
    public void constructor() {
        it.hasConstructor(withArgsSimilarToFields())
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    public void methodDecrypt() {
        it.hasMethod("decrypt", withParams("text: String"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("String");
    }

    @Test
    public void methodEncrypt() {
        it.hasMethod("encrypt", withParams("text: String"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("String");
    }
}


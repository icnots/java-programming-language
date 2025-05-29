import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.MethodOrderer.*;
import check.*;

@TestMethodOrder(OrderAnnotation.class)
public class BaseModelStructureTest {

    @BeforeAll
    public static void init() {
        CheckThat.theClass("iot.util.BaseModel", withInterface("iot.util.IotFunction"))
                 .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test @DisabledIf(notApplicable) @Order(1_00)
    public void fieldPowerStatus() {
        it.hasField("powerStatus: boolean")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_SUBCLASSES)
            .thatHas(GETTER)
            .thatHasNo(SETTER);
    }

    @Test @DisabledIf(notApplicable) @Order(1_01)
    public void fieldIdentifier() {
        it.hasField("identifier: String")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_SUBCLASSES)
            .thatHas(GETTER)
            .thatHasNo(SETTER);
    }

    @Test @DisabledIf(notApplicable) @Order(1_02)
    public void fieldDeviceType() {
        it.hasField("deviceType: iot.device.Category")
            .thatIs(INSTANCE_LEVEL, NOT_MODIFIABLE, VISIBLE_TO_NONE)
            .thatHas(GETTER)
            .thatHasNo(SETTER);
    }

    @Test @DisabledIf(notApplicable) @Order(2_00)
    public void constructorWithStringAndCategory() {
        it.hasConstructor(withParams("identifier: String", "deviceType: iot.device.Category"))
            .thatIs(VISIBLE_TO_ALL)
            .thatThrows("IllegalArgumentException");
    }

    @Test @DisabledIf(notApplicable) @Order(3_00)
    public void methodTurnOn() {
        it.hasMethod("turnOn", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

    @Test @DisabledIf(notApplicable) @Order(3_01)
    public void methodTurnOff() {
        it.hasMethod("turnOff", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

    @Test @DisabledIf(notApplicable) @Order(3_02)
    public void methodToggleState() {
        it.hasMethod("toggleState", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("String");
    }

    @Test @DisabledIf(notApplicable) @Order(3_03)
    public void methodGetPowerStatus() {
        it.hasMethod("getPowerStatus", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("boolean");
    }

    @Test @DisabledIf(notApplicable) @Order(3_03)
    public void methodGetIdentifier() {
        it.hasMethod("getIdentifier", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("String");
    }

    @Test @DisabledIf(notApplicable) @Order(3_03)
    public void methodGetDeviceType() {
        it.hasMethod("getDeviceType", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("iot.device.Category");
    }

    @Test @DisabledIf(notApplicable) @Order(3_04)
    public void text() {
        it.has(TEXTUAL_REPRESENTATION);
    }

    @Test @DisabledIf(notApplicable) @Order(3_05)
    public void eq() {
        it.has(EQUALITY_CHECK);
    }
}
import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.MethodOrderer.*;
import check.*;

@TestMethodOrder(OrderAnnotation.class)
public class ActionDeviceStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("iot.device.ActionDevice", withParent("iot.util.BaseModel"))
                 .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test @DisabledIf(notApplicable) @Order(1_00)
    public void fieldActions() {
        it.hasField("actions: HashMap of String to String")
            .thatIs(INSTANCE_LEVEL, NOT_MODIFIABLE, VISIBLE_TO_NONE)
            .thatHas(GETTER)
            .thatHasNo(SETTER);
    }

    @Test @DisabledIf(notApplicable) @Order(1_01)
    public void fieldLastAction() {
        it.hasField("lastAction: String")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHas(GETTER)
            .thatHasNo(SETTER);
    }

    @Test @DisabledIf(notApplicable) @Order(2_00)
    public void constructorWithStringAndCategory() {
        it.hasConstructor(withParams("identifier: String", "deviceType: iot.device.Category"))
            .thatIs(VISIBLE_TO_ALL)
            .thatThrows("iot.util.UnSupportedDevice");
    }

    @Test @DisabledIf(notApplicable) @Order(3_00)
    public void methodGetActions() {
        it.hasMethod("getActions", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("HashMap of String to String");
    }

    @Test @DisabledIf(notApplicable) @Order(3_01)
    public void methodGetLastAction() {
        it.hasMethod("getLastAction", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("String");
    }

    @Test @DisabledIf(notApplicable) @Order(3_02)
    public void methodAddAction() {
        it.hasMethod("addAction", withParams("actionType: String", "details: String"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

    @Test @DisabledIf(notApplicable) @Order(3_03)
    public void methodGetAvailableActions() {
        it.hasMethod("getAvailableActions", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("String");
    }

    @Test @DisabledIf(notApplicable) @Order(3_04)
    public void methodPerformAction() {
        it.hasMethod("performAction", withParams("actionType: String"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("String");
    }

    @Test @DisabledIf(notApplicable) @Order(3_05)
    public void methodToggleState() {
        it.hasMethod("toggleState", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("String");
    }
}
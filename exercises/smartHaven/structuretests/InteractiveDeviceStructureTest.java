import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.MethodOrderer.*;
import check.*;

@TestMethodOrder(OrderAnnotation.class)
public class InteractiveDeviceStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("iot.device.InteractiveDevice", withParent("iot.util.BaseModel"))
                 .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test @DisabledIf(notApplicable) @Order(1_00)
    public void fieldConnectionLink() {
        it.hasField("connectionLink: ArrayList of iot.util.BaseModel")
            .thatIs(INSTANCE_LEVEL, NOT_MODIFIABLE, VISIBLE_TO_NONE)
            .thatHas(GETTER)
            .thatHasNo(SETTER);
    }

    @Test @DisabledIf(notApplicable) @Order(1_01)
    public void fieldLightColor() {
        it.hasField("lightColor: String")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHas(GETTER)
            .thatHas(SETTER);
    }

    @Test @DisabledIf(notApplicable) @Order(2_00)
    public void constructorWithStringAndCategory() {
        it.hasConstructor(withParams("identifier: String", "deviceType: iot.device.Category"))
            .thatIs(VISIBLE_TO_ALL)
            .thatThrows("iot.util.UnSupportedDevice");
    }

    @Test @DisabledIf(notApplicable) @Order(3_00)
    public void methodGetLightColor() {
        it.hasMethod("getLightColor", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("String");
    }

    @Test @DisabledIf(notApplicable) @Order(3_01)
    public void methodSetLightColor() {
        it.hasMethod("setLightColor", withParams("lightColor: String"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

    @Test @DisabledIf(notApplicable) @Order(3_02)
    public void methodGetConnectionLink() {
        it.hasMethod("getConnectionLink", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("ArrayList of iot.util.BaseModel");
    }

    @Test @DisabledIf(notApplicable) @Order(3_03)
    public void methodLinkDevice() {
        it.hasMethod("linkDevice", withParams("dev: iot.util.BaseModel"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

    @Test @DisabledIf(notApplicable) @Order(3_04)
    public void methodBulkLinkSameType() {
        it.hasMethod("bulkLinkSameType", withParams("basemodels: vararg of iot.util.BaseModel"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

    @Test @DisabledIf(notApplicable) @Order(3_05)
    public void methodBulkLinkAnyType() {
        it.hasMethod("bulkLinkAnyType", withParams("basemodels: vararg of iot.util.BaseModel"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

     @Test @DisabledIf(notApplicable) @Order(3_06)
    public void methodSyncLights() {
        it.hasMethod("syncLights", withParams("lightColor: String"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("int");
    }

    @Test @DisabledIf(notApplicable) @Order(3_07)
    public void methodToggleState() {
        it.hasMethod("toggleState", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("String");
    }
}
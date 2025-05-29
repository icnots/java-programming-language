import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.MethodOrderer.*;
import check.*;

@TestMethodOrder(OrderAnnotation.class)
public class SupplierStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("iot.Supplier")
                 .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test @DisabledIf(notApplicable) @Order(2_00)
    public void constructor() {
        it.has(DEFAULT_CONSTRUCTOR);
    }

    @Test @DisabledIf(notApplicable) @Order(3_00)
    public void methodBringSupplies() {
        it.hasMethod("bringSupplies", withParams("n: int"))
          .thatIs(FULLY_IMPLEMENTED, USABLE_WITHOUT_INSTANCE, VISIBLE_TO_ALL)
          .thatReturns("ArrayList of iot.util.BaseModel");
    }
}
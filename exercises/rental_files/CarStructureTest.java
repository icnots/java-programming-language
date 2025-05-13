package rental.tests;

import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.condition.*;
import check.CheckThat;

@TestMethodOrder(OrderAnnotation.class)
public class CarStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("rental.Car")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatHas(TEXTUAL_REPRESENTATION);
    }

    @Order(1_1)
    @Test
    @DisabledIf(notApplicable)
    public void fieldBrand() {
        it.hasField("brand: String")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHasNo(GETTER, SETTER);
    }

    @Order(1_2)
    @Test
    @DisabledIf(notApplicable)
    public void fieldLicensePlate() {
        it.hasField("licensePlate: String")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHasNo(GETTER, SETTER);
    }

    @Order(1_3)
    @Test
    @DisabledIf(notApplicable)
    public void fieldPrice() {
        it.hasField("price: double")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHas(GETTER)
            .thatHasNo(SETTER);
    }

    @Test
    @DisabledIf(notApplicable)
    public void fieldMAX_PRICE() {
        it.hasField("MAX_PRICE: double")
            .thatIs(USABLE_WITHOUT_INSTANCE, NOT_MODIFIABLE, VISIBLE_TO_NONE)
            .thatHasNo(GETTER, SETTER)
            .thatHasValue(500.0);
    }

    @Test
    @DisabledIf(notApplicable)
    public void fieldCAR_OF_THE_YEAR() {
        it.hasField("CAR_OF_THE_YEAR: Car")
            .thatIs(USABLE_WITHOUT_INSTANCE, NOT_MODIFIABLE, VISIBLE_TO_NONE)
            .thatHasNo(GETTER, SETTER)
        	.thatHasContent("brand", "Alfa Romeo")
        	.thatHasContent("licensePlate", "ABC 123")
        	.thatHasContent("price", "MAX_PRICE");
    }

    @Order(2_0)
    @Test
    @DisabledIf(notApplicable)
    public void constructor() {
        it.hasConstructor(withArgsSimilarToFields())
            .thatIs(VISIBLE_TO_NONE);
    }

    @Test
    @DisabledIf(notApplicable)
    public void methodIsCheaperThan() {
        it.hasMethod("isCheaperThan", withParams("other: Car"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("boolean");
    }

    @Test
    @DisabledIf(notApplicable)
    public void methodDecreasePrice() {
        it.hasMethod("decreasePrice", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

    @Order(3_1)
    @Test
    @DisabledIf(notApplicable)
    public void methodMake() {
        it.hasMethod("make", withArgsSimilarToFields())
            .thatIs(FULLY_IMPLEMENTED, USABLE_WITHOUT_INSTANCE, VISIBLE_TO_ALL)
            .thatReturns("Car");
    }

    @Test
    @DisabledIf(notApplicable)
    public void methodIsValidLicensePlate() {
        it.hasMethod("isValidLicensePlate", withParams("licensePlate: String"))
            .thatIs(FULLY_IMPLEMENTED, USABLE_WITHOUT_INSTANCE, VISIBLE_TO_NONE)
            .thatReturns("boolean");
    }
}

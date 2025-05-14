package rental.tests;

import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import check.CheckThat;

public class CarRentalStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("rental.CarRental")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatHas(TEXTUAL_REPRESENTATION);
    }

    @Test
    @DisabledIf(notApplicable)
    public void fieldCars() {
        it.hasField("cars: ArrayList of Car")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    @DisabledIf(notApplicable)
    public void constructor() {
        it.hasConstructor(withArgs("filename: String"))
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    @DisabledIf(notApplicable)
    public void methodNumberOfCars() {
        it.hasMethod("numberOfCars", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("int");
    }

    // -----------------------------------

    @Test
    @DisabledIf(notApplicable)
    public void methodInsertionSort() {
        it.hasMethod("insertionSort", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

    @Test
    @DisabledIf(notApplicable)
    public void methodWeightedAverage() {
        it.hasMethod("weightedAverage", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("double");
    }

    // -----------------------------------

    @Test
    @DisabledIf(notApplicable)
    public void methodRentCheapest() {
        it.hasMethod("rentCheapest", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("Car");
    }

    @Test
    @DisabledIf(notApplicable)
    public void methodSale() {
        it.hasMethod("sale", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("ArrayList of Car");
    }
}


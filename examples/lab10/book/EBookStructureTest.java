package book;

import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import check.CheckThat;

public class EBookStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("printed.material.specific.EBook")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void fieldPdfSize() {
        it.hasField("pdfSize: int")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    public void fieldIsUnitPrefix() {
        it.hasField("isUnitPrefix: boolean")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    public void fieldUnit() {
        it.hasField("unit: String")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    public void constructor() {
        it.hasConstructor(withArgs("printed.material.Book", "int", "boolean", "String"))
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    public void methodDecode() {
        it.hasMethod("decode", withParams("String"))
            .thatIs(FULLY_IMPLEMENTED, USABLE_WITHOUT_INSTANCE, VISIBLE_TO_ALL)
            .thatReturns("EBook");
    }

    @Test
    public void methodGetPrice() {
        it.hasMethod("getPrice", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("int");
    }

    @Test
    @DisabledIf(notApplicable)
    public void text() {
        it.has(TEXTUAL_REPRESENTATION);
    }
}


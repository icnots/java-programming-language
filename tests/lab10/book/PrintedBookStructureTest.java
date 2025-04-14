package book;

import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import check.CheckThat;

public class PrintedBookStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("printed.material.specific.PrintedBook")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void fieldCoverType() {
        it.hasField("coverType: printed.material.CoverType")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_SUBCLASSES)
            .thatHasNo(GETTER, SETTER);
    }

    @Test
    public void constructor01() {
        it.hasConstructor(withArgs("author: String", "title: String", "pageCount: int", "coverType: printed.material.CoverType"))
            .thatIs(VISIBLE_TO_ALL)
            .thatCalls(theParent("with pageCount+6"));
    }

    @Test
    public void constructor02() {
        it.hasConstructor(withArgs("book: printed.material.Book"))
            .thatIs(VISIBLE_TO_ALL)
        	.thatCalls(theOtherConstructor(withAdditionalArgs("HARDCOVER")));
    }

    @Test
    public void methodDecode() {
        it.hasMethod("decode", withParams("String"))
            .thatIs(FULLY_IMPLEMENTED, USABLE_WITHOUT_INSTANCE, VISIBLE_TO_ALL)
            .thatReturns("PrintedBook");
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

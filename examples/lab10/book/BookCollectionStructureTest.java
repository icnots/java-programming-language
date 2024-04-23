package book;

import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class BookCollectionStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("printed.material.BookCollection")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void fieldBooks() {
        it.hasField("books: ArrayList of Book")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHas(GETTER)
            .thatHasNo(SETTER);
    }

    @Test
    public void constructor() {
        it.hasConstructor(withNoArgs())
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test
    public void methodAdd() {
        it.hasMethod("add", withParams("array of Book"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturnsNothing();
    }

    @Test
    public void methodLoad() {
        it.hasMethod("load", withParams("String"))
            .thatIs(FULLY_IMPLEMENTED, USABLE_WITHOUT_INSTANCE, VISIBLE_TO_ALL)
            .thatReturns("BookCollection");
    }

    @Test
    public void methodSave() {
        it.hasMethod("save", withParams("String"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("boolean");
    }
}


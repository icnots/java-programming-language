package book;

import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.*;
import org.junit.jupiter.api.condition.*;
import check.CheckThat;

@TestMethodOrder(OrderAnnotation.class)
public class BookStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("printed.material.Book")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void fieldDefaultAuthor() {
        it.hasField("defaultAuthor: String")
            .thatIs(USABLE_WITHOUT_INSTANCE, NOT_MODIFIABLE, VISIBLE_TO_ALL)
            .thatHasNo(GETTER, SETTER)
            .thatHasValue("John Steinbeck");
    }

    @Test
    public void fieldDefaultTitle() {
        it.hasField("defaultTitle: String")
            .thatIs(USABLE_WITHOUT_INSTANCE, NOT_MODIFIABLE, VISIBLE_TO_ALL)
            .thatHasNo(GETTER, SETTER)
        	.thatHasValue("Of Mice and Men");
    }

    @Test
    public void fieldDefaultPageCount() {
        it.hasField("defaultPageCount: int")
            .thatIs(USABLE_WITHOUT_INSTANCE, NOT_MODIFIABLE, VISIBLE_TO_ALL)
            .thatHasNo(GETTER, SETTER)
        	.thatHasValue(107);
    }

    @Test @Order(1_1)
    public void fieldAuthor() {
        it.hasField("author: String")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHas(GETTER)
            .thatHasNo(SETTER);
    }

    @Test @Order(1_2)
    public void fieldTitle() {
        it.hasField("title: String")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_NONE)
            .thatHas(GETTER)
            .thatHasNo(SETTER);
    }

    @Test @Order(1_3)
    public void fieldPageCount() {
        it.hasField("pageCount: int")
            .thatIs(INSTANCE_LEVEL, MODIFIABLE, VISIBLE_TO_SUBCLASSES)
            .thatHas(GETTER)
            .thatHasNo(SETTER);
    }

    @Test @Order(2_0)
    public void constructor01() {
        it.hasConstructor(withNoArgs())
            .thatIs(VISIBLE_TO_ALL)
            .thatCalls(theOtherConstructor(with("defaultAuthor", "defaultTitle", "defaultPageCount")));
    }

    @Test @Order(2_0)
    public void constructor02() {
        it.hasConstructor(withArgsSimilarToFields())
            .thatIs(VISIBLE_TO_ALL);
    }

    @Test @Order(3_0)
    public void methodCheckInitData() {
        it.hasMethod("checkInitData", withParams("String", "String", "int"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_NONE)
            .thatReturnsNothing();
    }

    @Test @Order(3_0)
    public void methodCreateReference() {
        it.hasMethod("createReference", withParams("String", "int", "int"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("String");
    }

    @Test @Order(3_0)
    public void methodDecode() {
        it.hasMethod("decode", withParams("String"))
            .thatIs(FULLY_IMPLEMENTED, USABLE_WITHOUT_INSTANCE, VISIBLE_TO_ALL)
            .thatReturns("Book");
    }

    @Test @Order(3_0)
    public void methodGetAuthorWithInitials() {
        it.hasMethod("getAuthorWithInitials", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_SUBCLASSES)
            .thatReturns("String");
    }

    @Test @Order(3_0)
    public void methodGetPrice() {
        it.hasMethod("getPrice", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("int");
    }

    @Test @Order(3_0)
    public void methodGetShortInfo() {
        it.hasMethod("getShortInfo", withNoParams())
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL)
            .thatReturns("String");
    }

    @Test @Order(3_0)
    public void methodInitBook() {
        it.hasMethod("initBook", withParams("String", "String", "int"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_SUBCLASSES)
            .thatReturnsNothing();
    }

    @Test @Order(3_0)
    @DisabledIf(notApplicable)
    public void text() {
        it.has(TEXTUAL_REPRESENTATION);
    }
}

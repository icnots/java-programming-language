package book;

import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import check.CheckThat;

public class DamagedBookStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("printed.material.specific.DamagedBook", withParent("printed.material.Book"))
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test
    public void constructor() {
        it.hasConstructor(withNoArgs())
            .thatIs(VISIBLE_TO_ALL)
            .thatCalls("parent");
    }
}


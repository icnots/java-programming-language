import static check.CheckThat.*;
import static check.CheckThat.Condition.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import check.CheckThat;

@TestMethodOrder(OrderAnnotation.class)
public class ArtistStructureTest {
    @BeforeAll
    public static void init() {
        CheckThat.theClass("music.recording.Artist")
            .thatIs(FULLY_IMPLEMENTED, INSTANCE_LEVEL, VISIBLE_TO_ALL);
    }

    @Test @Order(1_1)
    public void fieldName() {
        it.hasField("name: String")
            .thatIs(INSTANCE_LEVEL, NOT_MODIFIABLE, VISIBLE_TO_NONE)
            .thatHas(GETTER)
            .thatHasNo(SETTER);
    }

    @Test @Order(1_2)
    public void fieldLabel() {
        it.hasField("label: RecordLabel")
            .thatIs(INSTANCE_LEVEL, NOT_MODIFIABLE, VISIBLE_TO_NONE)
            .thatHas(GETTER)
            .thatHasNo(SETTER);
    }

    @Test @Order(2_0)
    public void constructor() {
        it.hasConstructor(withArgsSimilarToFields())
            .thatIs(VISIBLE_TO_ALL);
    }
}


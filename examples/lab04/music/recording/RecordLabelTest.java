package music.recording;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RecordLabelTest {
    @Test
    public void labelName() {
        RecordLabel label = new RecordLabel("X", 100);
        assertEquals("X", label.getName());
    }

    @Test
    public void labelWorth() {
        RecordLabel label = new RecordLabel("X", 100);
        assertEquals(100, label.getCash());
    }

    @Test
    public void labelIncome() {
        RecordLabel label = new RecordLabel("X", 100);
        label.gotIncome(200);
        assertEquals(300, label.getCash());
    }
}


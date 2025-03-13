package music.fan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import music.recording.Artist;
import music.recording.RecordLabel;

public class FanTest {
    @Test
    public void name() {
        RecordLabel label = new RecordLabel("X", 100);
        Artist artist = new Artist("A", label);
        Fan fan = new Fan("F1", artist);
        assertEquals("F1", fan.getName());
    }

    @Test
    public void faveName() {
        RecordLabel label = new RecordLabel("X", 100);
        Artist artist = new Artist("A", label);
        Fan fan = new Fan("F1", artist);
        assertEquals("A", fan.getFavourite().getName());
    }

    @Test
    public void faveLabelName() {
    	RecordLabel label = new RecordLabel("X", 100);
    	Artist artist = new Artist("A", label);
    	Fan fan = new Fan("F1", artist);
    	assertEquals("X", fan.getFavourite().getLabel().getName());
    }

    @Test
    public void initMoneySpent() {
        RecordLabel label = new RecordLabel("X", 100);
        Artist artist = new Artist("A", label);
        Fan fan = new Fan("F1", artist);
        assertEquals(0, fan.getMoneySpent());
    }

    @Test
    public void buyAlone() {
        RecordLabel label = new RecordLabel("X", 100);
        Artist artist = new Artist("A", label);
        Fan fan = new Fan("F1", artist);

        fan.buyMerchandise(100);

        assertEquals(100, fan.getMoneySpent());
        assertEquals(150, label.getCash());
    }

    @Test
    public void buyWithAnotherFan() {
        RecordLabel label = new RecordLabel("X", 100);
        Artist artist = new Artist("A", label);
        Fan fan1 = new Fan("F1", artist);
        Fan fan2 = new Fan("F2", artist);

        fan1.buyMerchandise(100, fan2);

        assertEquals(90, fan1.getMoneySpent());
        assertEquals(90, fan2.getMoneySpent());
        assertEquals(190, label.getCash());
    }

    @Test
    public void buyWithTenFans() {
        RecordLabel label = new RecordLabel("X", 100);
        Artist artist = new Artist("A", label);
        Fan fan1 = new Fan("F1", artist);
        Fan fan2 = new Fan("F2", artist);

        int costPerItem = fan1.buyMerchandise(100, fan2, fan2, fan2, fan2, fan2, fan2, fan2, fan2, fan2, fan2);

        assertEquals(80, costPerItem);
        assertEquals(80, fan1.getMoneySpent());
        assertEquals(80*10, fan2.getMoneySpent());
        assertEquals(100+11*80/2, label.getCash());
    }

    @Test
    public void favesAtSameLabel() {
        RecordLabel label = new RecordLabel("X", 100);
        Artist artist1 = new Artist("A1", label);
        Artist artist2 = new Artist("A2", label);
        Fan fan1 = new Fan("F1", artist1);
        Fan fan2 = new Fan("F2", artist2);

        assertTrue(fan1.favesAtSameLabel(fan2));
    }

    @Test
    public void favesAtSameNameButDifferentLabel() {
        RecordLabel label1 = new RecordLabel("X", 100);
        RecordLabel label2 = new RecordLabel("X", 256);
        Artist artist1 = new Artist("A1", label1);
        Artist artist2 = new Artist("A2", label2);
        Fan fan1 = new Fan("F1", artist1);
        Fan fan2 = new Fan("F2", artist2);

        assertFalse(fan1.favesAtSameLabel(fan2));
    }

    @Test
    public void favesAtDifferentLabel() {
        RecordLabel label1 = new RecordLabel("X", 100);
        RecordLabel label2 = new RecordLabel("XYZ", 256);
        Artist artist1 = new Artist("A1", label1);
        Artist artist2 = new Artist("A2", label2);
        Fan fan1 = new Fan("F1", artist1);
        Fan fan2 = new Fan("F2", artist2);

        assertFalse(fan1.favesAtSameLabel(fan2));
    }

    @Test
    public void toString1() {
        RecordLabel label = new RecordLabel("X", 100);
        Artist artist = new Artist("A", label);
        Fan fan = new Fan("F", artist);

        assertEquals("Fan(name=F, fave=A@X, spent=0)", fan.toString1());

        fan.buyMerchandise(100);
        assertEquals("Fan(name=F, fave=A@X, spent=100)", fan.toString1());
    }

    @Test
    public void toString2() {
        RecordLabel label = new RecordLabel("X", 100);
        Artist artist = new Artist("A", label);
        Fan fan = new Fan("F", artist);

        assertEquals("Fan(name=F, fave=A@X, spent=0)", fan.toString2());

        fan.buyMerchandise(100);
        assertEquals("Fan(name=F, fave=A@X, spent=100)", fan.toString2());
    }

    @Test
    public void toString3() {
        RecordLabel label = new RecordLabel("X", 100);
        Artist artist = new Artist("A", label);
        Fan fan = new Fan("F", artist);

        assertEquals("Fan(name=F, fave=A@X, spent=0)", fan.toString3());

        fan.buyMerchandise(100);
        assertEquals("Fan(name=F, fave=A@X, spent=100)", fan.toString3());
    }

    @Test
    public void toString4() {
        RecordLabel label = new RecordLabel("X", 100);
        Artist artist = new Artist("A", label);
        Fan fan = new Fan("F", artist);

        assertEquals("Fan(name=F, fave=A@X, spent=0)", fan.toString4());

        fan.buyMerchandise(100);
        assertEquals("Fan(name=F, fave=A@X, spent=100)", fan.toString4());
    }
}


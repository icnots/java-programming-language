package music.recording;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ArtistTest {
    @Test
    public void name() {
        RecordLabel label = new RecordLabel("X", 100);
        Artist artist = new Artist("A", label);
        assertEquals("A", artist.getName());
    }

    @Test
    public void labelNetWorth() {
        RecordLabel label = new RecordLabel("X", 100);
        Artist artist = new Artist("A", label);
        assertEquals(100, artist.getLabel().getCash());
    }
}


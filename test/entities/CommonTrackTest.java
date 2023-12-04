package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonTrackTest {

    private CommonTrack track;

    @BeforeEach
    void setUp() {
        track = new CommonTrack("trackID123", "Track Name", "Artist1, Artist2", 300, true, "http://example.com/image.jpg");
    }

    @Test
    void getID() {
        assertEquals("trackID123", track.getID(), "getID should return the correct ID.");
    }

    @Test
    void getName() {
        assertEquals("Track Name", track.getName(), "getName should return the correct track name.");
    }

    @Test
    void getArtists() {
        assertEquals("Artist1, Artist2", track.getArtists(), "getArtists should return the correct artists string.");
    }

    @Test
    void getDuration() {
        assertEquals(300, track.getDuration(), "getDuration should return the correct duration.");
    }

    @Test
    void isExplicit() {
        assertTrue(track.isExplicit(), "isExplicit should return true for explicit tracks.");
    }

    @Test
    void getImageURL() {
        assertEquals("http://example.com/image.jpg", track.getImageURL(), "getImageURL should return the correct image URL.");
    }
}

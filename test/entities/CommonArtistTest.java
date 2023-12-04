package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonArtistTest {

    private CommonArtist artist;

    @BeforeEach
    void setUp() {
        artist = new CommonArtist("123", "http://example.com/image.jpg", "Artist Name", 1000);
    }

    @Test
    void getID() {
        assertEquals("123", artist.getID(), "getID should return the correct ID.");
    }

    @Test
    void getImageUrl() {
        assertEquals("http://example.com/image.jpg", artist.getImageUrl(), "getImageUrl should return the correct URL.");
    }

    @Test
    void getName() {
        assertEquals("Artist Name", artist.getName(), "getName should return the correct name.");
    }

    @Test
    void getNumFollowers() {
        assertEquals(1000, artist.getNumFollowers(), "getNumFollowers should return the correct number of followers.");
    }
}

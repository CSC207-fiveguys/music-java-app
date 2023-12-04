package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CommonPlaylistTest {

    private CommonPlaylist playlist;
    private CommonUser owner;

    @BeforeEach
    void setUp() {
        owner = new CommonUser("user123", "password123");
        ArrayList<String> initialTracks = new ArrayList<>(Arrays.asList("track1", "track2", "track3"));
        playlist = new CommonPlaylist("My Playlist", owner, initialTracks);
    }

    @Test
    void getName() {
        assertEquals("My Playlist", playlist.getName(), "getName should return the correct playlist name.");
    }

    @Test
    void getOwner() {
        assertEquals(owner, playlist.getOwner(), "getOwner should return the correct User object.");
    }

    @Test
    void getTracks() {
        assertEquals(Arrays.asList("track1", "track2", "track3"), playlist.getTracks(), "getTracks should return the correct list of tracks.");
    }

    @Test
    void addTrack() {
        playlist.addTrack("track4");
        assertTrue(playlist.getTracks().contains("track4"), "addTrack should add the track to the playlist.");
    }

    @Test
    void removeTrack() {
        playlist.removeTrack("track2");
        assertFalse(playlist.getTracks().contains("track2"), "removeTrack should remove the track from the playlist.");
    }
}

package data_access;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpotifyAPITest {
    SpotifyAPI spotifyAPI;
    SpotifyDataAccessObject spotifyDataAccessObject;
    String accessToken;
    @BeforeEach
    void setup() {
        TrackDataAccessObject trackDataAccessObject = new TrackDataAccessObject();
        ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
        spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject);
        spotifyAPI = new SpotifyAPI();
    }

    @Test
    void requestToken() {
        String accessToken = spotifyAPI.requestToken();
        System.out.println(accessToken);
        assertNotNull(accessToken);
    }

    @Test
    void search_artist() {
        JSONObject artists = spotifyAPI.search_artist("string", accessToken);
        assertNotNull(artists);
    }

    @Test
    void search_track() {
        JSONObject tracks = spotifyAPI.search_track("string", accessToken);
        assertNotNull(tracks);
    }

    @Test
    void get_artist() {
        JSONObject artist = spotifyAPI.get_artist("0TnOYISbd1XYRBk9myaseg", accessToken);
        assertNotNull(artist);
    }

    @Test
    void get_track() {
        JSONObject track = spotifyAPI.get_track("11dFghVXANMlKmJXsNCbNl", accessToken);
        assertNotNull(track);
    }

    @Test
    void get_artist_top_tracks() {
        JSONObject tracks = spotifyAPI.get_artist_top_tracks("0TnOYISbd1XYRBk9myaseg", accessToken);
        assertNotNull(tracks);
    }
}
package services.view_playlist;

import data_access.TrackDataAccessObject;
import entities.CommonPlaylist;
import entities.CommonTrack;
import entities.CommonUser;
import entities.Playlist;
import entities.Track;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class ViewPlaylistInteractorTest {

    private ViewPlaylistInteractor interactor;
    private ViewPlaylistDataAccessInterface userDataAccessObject;
    private ViewPlaylistOutputBoundary outputBoundary;
    private TrackDataAccessObject trackDataAccessObject;

    @BeforeEach
    void setUp() {
        userDataAccessObject = new ViewPlaylistDataAccessInterface() {
            @Override
            public Playlist getPlaylist(String playlistName, String username) {
                if ("testPlaylist".equals(playlistName) && "testUser".equals(username)) {
                    return new CommonPlaylist(playlistName, new CommonUser("user1", "password1"), new ArrayList<>(Arrays.asList("track1", "track2")));
                }
                return null;
            }
        };

        trackDataAccessObject = new TrackDataAccessObject() {
            @Override
            public Track getTrack(String trackID) {
                switch (trackID) {
                    case "track1":
                        return new CommonTrack("1234jkl", "Track 1", "Artist 1", 300, true, "google.com");
                    case "track2":
                        return new CommonTrack("5678asd", "Track 2", "Artist 2", 250, false, "bing.com" );
                    default:
                        return null;
                }
            }
        };

        outputBoundary = new ViewPlaylistOutputBoundary() {
            @Override
            public void prepareSuccessView(ViewPlaylistOutputData outputData) {
                assertNotNull(outputData, "Output data should not be null");
                assertEquals("testPlaylist", outputData.playlistName, "Playlist name should match");
                assertFalse(outputData.tracks.isEmpty(), "Tracks list should not be empty");
            }
        };

        interactor = new ViewPlaylistInteractor(userDataAccessObject, outputBoundary, trackDataAccessObject);
    }

    @Test
    void execute_ViewExistingPlaylist() {
        ViewPlaylistInputData inputData = new ViewPlaylistInputData("testUser", "testPlaylist", false);
        interactor.execute(inputData);
    }
}

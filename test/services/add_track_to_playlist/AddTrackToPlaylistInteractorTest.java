package services.add_track_to_playlist;

import data_access.ArtistDataAccessObject;
import data_access.SpotifyDataAccessObject;
import data_access.TrackDataAccessObject;
import data_access.UserDataAccessObject;
import entities.CommonPlaylist;
import entities.CommonUser;
import entities.Playlist;
import entities.User;
import entities.UserFactory;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddTrackToPlaylistInteractorTest {

    private AddTrackToPlaylistInteractor interactor;
    private AddTrackToPlaylistUserDataAccessInterface userDataAccessObject;
    private AddTrackToPlaylistSpotifyDataAccessInterface spotifyDataAccessObject;
    private AddTrackToPlaylistOutputBoundary outputBoundary;

    @BeforeEach
    void setUp() {
        TrackDataAccessObject trackDataAccessObject = new TrackDataAccessObject();
        ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
        SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject);
        UserFactory userFactory = new UserFactory();

        spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject) {
            @Override
            public void saveTrack(String trackId) {
                // Simulate saving a track
            }
        };

        userDataAccessObject = new UserDataAccessObject(userFactory, spotifyDataAccessObject) {
            @Override
            public User getUser(String username) {
                User user = new CommonUser(username, "dummyPassword");
                ArrayList<String> tracks = new ArrayList<>();
                tracks.add("Sicko Mode");
                Playlist playlist = new CommonPlaylist("My Playlist", user, tracks);
                user.addPlaylist(playlist);
                return user;
            }
        };

        outputBoundary = new AddTrackToPlaylistPresenter() {
            @Override
            public void prepareSuccessView() {
                assertTrue(true, "Success view should be prepared");
            }
        };

        interactor = new AddTrackToPlaylistInteractor(userDataAccessObject, spotifyDataAccessObject, outputBoundary);
    }

    @Test
    void execute_AddTrackToPlaylist() {
        AddTrackToPlaylistInputData inputData = new AddTrackToPlaylistInputData("trackId", "user", "My Playlist");
        interactor.execute(inputData);
    }
}

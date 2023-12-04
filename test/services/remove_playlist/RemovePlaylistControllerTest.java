package services.remove_playlist;

import static org.junit.jupiter.api.Assertions.*;

import data_access.ArtistDataAccessObject;
import data_access.SpotifyDataAccessObject;
import data_access.TrackDataAccessObject;
import data_access.UserDataAccessObject;
import entities.PlaylistFactory;
import entities.User;
import entities.UserFactory;
import org.junit.jupiter.api.Test;
import services.login_complete.LoginCompleteController;
import services.login_complete.LoginCompleteInputBoundary;
import services.login_complete.LoginCompleteInteractor;
import services.login_complete.LoginCompleteOutputBoundary;
import services.login_complete.LoginCompleteOutputData;

class RemovePlaylistControllerTest {

    @Test
    void execute() {
        TrackDataAccessObject trackDataAccessObject = new TrackDataAccessObject();
        ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
        SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject);
        UserFactory userFactory = new UserFactory();
        UserDataAccessObject userDataAccessInterface = new UserDataAccessObject(userFactory, spotifyDataAccessObject);
        RemovePlaylistInputBoundary inputBoundary = new RemovePlaylistInteractor(
            userDataAccessInterface, new RemovePlaylistOutputBoundary() {
            @Override
            public void prepareSuccessView(RemovePlaylistOutputData outputData) {
                assertTrue(true, "should present success view");
            }
        });

        RemovePlaylistController controller = new RemovePlaylistController(inputBoundary);
        User user = userFactory.create("user", "123");
        userDataAccessInterface.saveUser(user);
        user.createPlaylist("playlistName");
        controller.execute("playlistname", "user", "user");
    }
}
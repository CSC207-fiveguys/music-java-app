package services.add_friend;

import data_access.ArtistDataAccessObject;
import data_access.SpotifyDataAccessObject;
import data_access.TrackDataAccessObject;
import data_access.UserDataAccessObject;
import entities.CommonUser;
import entities.Playlist;
import entities.User;
import entities.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddFriendInteractorTest {
    @Test
    void successTest() {
        AddFriendInputData inputData = new AddFriendInputData("friendUsername", "username");
        UserFactory userFactory = new UserFactory();
        TrackDataAccessObject trackDataAccessObject  = new TrackDataAccessObject();
        ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
        SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject);
        UserDataAccessObject userDataAccessInterface = new UserDataAccessObject(userFactory, spotifyDataAccessObject);
        User user = userFactory.create("friendUsername", "123");
        User user1 = userFactory.create("username", "123");
        userDataAccessInterface.saveUser(user);
        userDataAccessInterface.saveUser(user1);
        user.createPlaylist("Playlistname");
        AddFriendOutputBoundary addFriendPresenter = new AddFriendOutputBoundary() {
            @Override
            public void prepareSuccessView(AddFriendOutputData friendUsername) {
                assertEquals("friendUsername", friendUsername.username);
                assertNotNull(friendUsername.userPlaylists);
            }

            @Override
            public void prepareFailView() {
                fail("Use case failure is unexpected");
            }
        };

        AddFriendInputBoundary interactor = new AddFriendInteractor(userDataAccessInterface, addFriendPresenter);
        interactor.execute(inputData);
    }

    @Test
    void failureFriendExists() {
        AddFriendInputData inputData = new AddFriendInputData("friendUsername", "username");
        UserFactory userFactory = new UserFactory();
        TrackDataAccessObject trackDataAccessObject  = new TrackDataAccessObject();
        ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
        SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject);
        UserDataAccessObject userDataAccessInterface = new UserDataAccessObject(userFactory, spotifyDataAccessObject);
        User username = userFactory.create("username", "123");
        User friendUsername = userFactory.create("friendUsername", "123");
        userDataAccessInterface.saveUser(username);
        userDataAccessInterface.saveUser(friendUsername);
        friendUsername.createPlaylist("Playlistname");
        username.addFriend(friendUsername);
        AddFriendOutputBoundary addFriendPresenter = new AddFriendOutputBoundary() {
            @Override
            public void prepareSuccessView(AddFriendOutputData friendUsername) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView() {
                assertTrue(true, "Use case failure is expected");
            }
        };

        AddFriendInputBoundary interactor = new AddFriendInteractor(userDataAccessInterface, addFriendPresenter);
        interactor.execute(inputData);
    }
}

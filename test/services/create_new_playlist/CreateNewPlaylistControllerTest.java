package services.create_new_playlist;

import static org.junit.jupiter.api.Assertions.*;

import data_access.ArtistDataAccessObject;
import data_access.SpotifyDataAccessObject;
import data_access.TrackDataAccessObject;
import data_access.UserDataAccessObject;
import entities.UserFactory;
import org.junit.jupiter.api.Test;
import services.add_friend.AddFriendController;
import services.add_friend.AddFriendInputBoundary;
import services.add_friend.AddFriendInteractor;
import services.add_friend.AddFriendOutputBoundary;
import services.add_friend.AddFriendOutputData;
import services.add_friend.AddFriendPresenter;
import view.logged_in.tabs.FollowedFriendsViewModel;
import view.logged_in.tabs.FollowedFriendsViewState;
import view.logged_in.tabs.MyLibraryViewModel;
import view.logged_in.tabs.MyLibraryViewState;

class CreateNewPlaylistControllerTest {

    @Test
    void successTest() {
        TrackDataAccessObject trackDataAccessObject = new TrackDataAccessObject();
        ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
        SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject);
        UserFactory userFactory = new UserFactory();
        MyLibraryViewModel myLibraryViewModel = new MyLibraryViewModel("view", new MyLibraryViewState());
        UserDataAccessObject userDataAccessInterface = new UserDataAccessObject(userFactory, spotifyDataAccessObject);
        CreateNewPlaylistInputBoundary inputBoundary = new CreateNewPlaylistInteractor(
            userDataAccessInterface, new CreateNewPlaylistPresenter(myLibraryViewModel) {
            @Override
            public void prepareSuccessView(CreateNewPlaylistOutputData outputData) {
                assertTrue(true, "should be success");
            }

            @Override
            public void prepareFailView(String error) {
                fail("should not be success");
            }
        });

        FollowedFriendsViewState followedFriendsViewState = new FollowedFriendsViewState();
        FollowedFriendsViewModel followedFriendsViewModel = new FollowedFriendsViewModel("followed friends", followedFriendsViewState);
        CreateNewPlaylistController controller = new CreateNewPlaylistController(inputBoundary);
        userDataAccessInterface.saveUser(userFactory.create("username", "123"));
        controller.execute("123", "username");
    }
}
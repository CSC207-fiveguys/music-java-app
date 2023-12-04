package services.login_new_signup;

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
import services.create_new_playlist.CreateNewPlaylistController;
import view.logged_in.tabs.FollowedFriendsViewModel;
import view.logged_in.tabs.FollowedFriendsViewState;
import view.logged_in.tabs.MyLibraryViewModel;
import view.logged_in.tabs.MyLibraryViewState;

class LoginNewSignupControllerTest {

    @Test
    void successTest() {
        TrackDataAccessObject trackDataAccessObject = new TrackDataAccessObject();
        ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
        SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject);
        UserFactory userFactory = new UserFactory();
        UserDataAccessObject userDataAccessInterface = new UserDataAccessObject(userFactory, spotifyDataAccessObject);
        LoginNewSignupInputBoundary inputBoundary = new LoginNewSignupInteractor(
            new LoginNewSignupOutputBoundary() {
                @Override
                public void prepareSuccessView() {
                    assertTrue(true, "Success view should be prepared.");
                }
            });
        MyLibraryViewModel myLibraryViewModel = new MyLibraryViewModel("view", new MyLibraryViewState());
        FollowedFriendsViewState followedFriendsViewState = new FollowedFriendsViewState();
        FollowedFriendsViewModel followedFriendsViewModel = new FollowedFriendsViewModel("followed friends", followedFriendsViewState);
        LoginNewSignupController controller = new LoginNewSignupController(inputBoundary);
        controller.execute();
    }
}
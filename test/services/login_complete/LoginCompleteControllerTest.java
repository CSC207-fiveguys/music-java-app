package services.login_complete;

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

class LoginCompleteControllerTest {

    @Test
    void execute() {
        TrackDataAccessObject trackDataAccessObject = new TrackDataAccessObject();
        ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
        SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject);
        UserFactory userFactory = new UserFactory();
        UserDataAccessObject userDataAccessInterface = new UserDataAccessObject(userFactory, spotifyDataAccessObject);
        LoginCompleteInputBoundary inputBoundary = new LoginCompleteInteractor(
            new LoginCompleteOutputBoundary() {
                @Override
                public void prepareSuccessView(LoginCompleteOutputData user) {
                    assertTrue(true, "Success view should be presented");
                }

                @Override
                public void prepareFailView(String error) {
                    fail("failure view should not be presented");
                }
            }, userDataAccessInterface);

        LoginCompleteController controller = new LoginCompleteController(inputBoundary);
        userDataAccessInterface.saveUser(userFactory.create("user", "123"));
        controller.execute("user", "123");
    }
}
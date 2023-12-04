package services.add_friend;

import static org.junit.jupiter.api.Assertions.*;

import data_access.ArtistDataAccessObject;
import data_access.SpotifyDataAccessObject;
import data_access.TrackDataAccessObject;
import data_access.UserDataAccessObject;
import entities.UserFactory;
import org.junit.jupiter.api.Test;
import services.login_complete.LoginCompleteController;
import services.login_complete.LoginCompleteInputBoundary;
import services.login_complete.LoginCompleteInteractor;
import services.login_complete.LoginCompleteOutputBoundary;
import services.login_complete.LoginCompleteOutputData;

class AddFriendControllerTest {

    @Test

    void execute() {
        TrackDataAccessObject trackDataAccessObject = new TrackDataAccessObject();
        ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
        SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject);
        UserFactory userFactory = new UserFactory();
        UserDataAccessObject userDataAccessInterface = new UserDataAccessObject(userFactory, spotifyDataAccessObject);
        AddFriendInputBoundary inputBoundary = new AddFriendInteractor(userDataAccessInterface,
            new AddFriendOutputBoundary() {
                @Override
                public void prepareSuccessView(AddFriendOutputData friendUsername) {
                    assertTrue(true, "should present success");
                }

                @Override
                public void prepareFailView() {
                    fail("should not present fail");
                }
            });

        AddFriendController controller = new AddFriendController(inputBoundary);
        userDataAccessInterface.saveUser(userFactory.create("user", "123"));
        userDataAccessInterface.saveUser(userFactory.create("friendUsername", "123"));
        controller.execute("friendUsername", "user");
    }
}
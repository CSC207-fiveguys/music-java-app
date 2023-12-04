package services.signup_complete;

import static org.junit.jupiter.api.Assertions.*;

import data_access.ArtistDataAccessObject;
import data_access.SpotifyDataAccessObject;
import data_access.TrackDataAccessObject;
import data_access.UserDataAccessObject;
import entities.UserFactory;
import org.junit.jupiter.api.Test;
import services.search.SearchController;
import services.search.SearchInputBoundary;
import services.search.SearchInteractor;
import services.search.SearchOutputBoundary;
import services.search.SearchOutputData;

class SignupCompleteControllerTest {

    @Test
    void execute() {
        TrackDataAccessObject trackDataAccessObject = new TrackDataAccessObject();
        ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
        SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject);
        UserFactory userFactory = new UserFactory();
        UserDataAccessObject userDataAccessInterface = new UserDataAccessObject(userFactory, spotifyDataAccessObject);
        SignupCompleteInputBoundary signupCompleteInputBoundary = new SignupCompleteInteractor(
            userDataAccessInterface, new SignupCompleteOutputBoundary() {
            @Override
            public void prepareSuccessView(SignupCompleteOutputData user) {
                assertTrue(true, "should present success view");
            }

            @Override
            public void prepareFailView(String error) {
                fail("should not present fail");
            }
        });

        SignupCompleteController controller = new SignupCompleteController(signupCompleteInputBoundary);
        controller.execute("drake", "123", "123");
    }
}
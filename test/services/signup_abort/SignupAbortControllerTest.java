package services.signup_abort;

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

class SignupAbortControllerTest {

    @Test
    void execute() {
        TrackDataAccessObject trackDataAccessObject = new TrackDataAccessObject();
        ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
        SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject);
        UserFactory userFactory = new UserFactory();
        UserDataAccessObject userDataAccessInterface = new UserDataAccessObject(userFactory, spotifyDataAccessObject);
        SignupAbortInputBoundary inputBoundary = new SignupAbortInteractor(
            new SignupAbortOutputBoundary() {
                @Override
                public void prepareSuccessView() {
                    assertTrue(true, "should present success view");
                }
            });

        SignupAbortController signupAbortController = new SignupAbortController(inputBoundary);
        signupAbortController.execute();
    }
}
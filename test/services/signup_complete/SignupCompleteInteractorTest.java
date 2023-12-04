package services.signup_complete;

import data_access.ArtistDataAccessObject;
import data_access.SpotifyDataAccessObject;
import data_access.TrackDataAccessObject;
import data_access.UserDataAccessObject;
import entities.User;
import entities.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SignupCompleteInteractorTest {

    private SignupCompleteInteractor interactor;
    private UserDataAccessObject userDataAccessObject;
    private SignupCompleteOutputBoundary outputBoundary;

    @BeforeEach
    void setUp() {
        TrackDataAccessObject trackDataAccessObject = new TrackDataAccessObject();
        ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
        SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject);
        UserFactory userFactory = new UserFactory();
        userDataAccessObject = new UserDataAccessObject(userFactory, spotifyDataAccessObject) {
            @Override
            public boolean exists(String username) {
                return "existingUser".equals(username);
            }

            @Override
            public void saveUser(User user) {
                // Implementation for saving a user
            }
        };

        outputBoundary = new SignupCompleteOutputBoundary() {
            @Override
            public void prepareSuccessView(SignupCompleteOutputData outputData) {
                assertNotNull(outputData, "Output data should not be null");
                assertEquals("newUser", outputData.getUsername(), "Username should match");
            }

            @Override
            public void prepareFailView(String error) {
                assertNotNull(error, "Error message should not be null");
            }
        };

        interactor = new SignupCompleteInteractor(userDataAccessObject, outputBoundary);
    }

    @Test
    void successTest() {
        SignupCompleteInputData inputData = new SignupCompleteInputData("newUser", "password", "password");
        interactor.execute(inputData);
    }

    @Test
    void failureUsernameExists() {
        SignupCompleteInputData inputData = new SignupCompleteInputData("existingUser", "password", "password");
        interactor.execute(inputData);
    }

    @Test
    void failurePasswordMismatch() {
        SignupCompleteInputData inputData = new SignupCompleteInputData("newUser", "password1", "password2");
        interactor.execute(inputData);
    }
}

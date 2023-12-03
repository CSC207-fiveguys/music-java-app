package services.create_new_playlist;

import entities.CommonUser;
import entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CreateNewPlaylistInteractorTest {

    private CreateNewPlaylistInteractor interactor;
    private CreateNewPlaylistDataAccessInterface userDataAccessObject;
    private CreateNewPlaylistOutputBoundary outputBoundary;

    @BeforeEach
    void setUp() {
        userDataAccessObject = new CreateNewPlaylistDataAccessInterface() {
            @Override
            public User getUser(String username) {
                // Assuming User has appropriate constructor and methods
                User user = new CommonUser(username, "password");
                if (username.equals("UserWithPlaylist")) {
                    user.createPlaylist("Existing Playlist");
                }
                return user;
            }
        };

        outputBoundary = new CreateNewPlaylistOutputBoundary() {
            @Override
            public void prepareSuccessView(CreateNewPlaylistOutputData outputData) {
                assertNotNull(outputData, "Output data should not be null");
                assertEquals("TestUser", outputData.username, "Username should match");
                assertEquals("New Playlist", outputData.playlistname, "Playlist name should match");
                assertTrue(outputData.tracks.isEmpty(), "New playlist should have no tracks");
            }

            @Override
            public void prepareFailView(String error) {
                assertNotNull(error, "Error message should not be null");
                assertEquals("New Playlist already exists", error, "Error message should indicate existing playlist");
            }
        };

        interactor = new CreateNewPlaylistInteractor(userDataAccessObject, outputBoundary);
    }

    @Test
    void execute_SuccessfulCreation() {
        CreateNewPlaylistInputData inputData = new CreateNewPlaylistInputData("TestUser", "New Playlist");
        interactor.execute(inputData);
    }

    @Test
    void execute_FailedCreation_AlreadyExists() {
        CreateNewPlaylistInputData inputData = new CreateNewPlaylistInputData("UserWithPlaylist", "Existing Playlist");
        interactor.execute(inputData);
    }
}

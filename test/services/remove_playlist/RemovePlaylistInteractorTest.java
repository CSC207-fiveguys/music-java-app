package services.remove_playlist;

import entities.CommonUser;
import entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RemovePlaylistInteractorTest {

    private RemovePlaylistInteractor interactor;
    private RemovePlaylistDataAccessInterface userDataAccessObject;
    private RemovePlaylistOutputBoundary outputBoundary;

    @BeforeEach
    void setUp() {
        userDataAccessObject = new RemovePlaylistDataAccessInterface() {
            @Override
            public User getUser(String username) {
                User user = new CommonUser(username, "password");
                user.createPlaylist("Test Playlist");
                return user;
            }
        };

        outputBoundary = new RemovePlaylistOutputBoundary() {
            @Override
            public void prepareSuccessView(RemovePlaylistOutputData outputData) {
                assertNotNull(outputData, "Output data should not be null");
                assertEquals("Test Playlist", outputData.playlistname, "Playlist name should match");
                assertEquals("TestUser", outputData.username, "Username should match");
            }
        };

        interactor = new RemovePlaylistInteractor(userDataAccessObject, outputBoundary);
    }

    @Test
    void execute_RemoveExistingPlaylist() {
        RemovePlaylistInputData inputData = new RemovePlaylistInputData("TestPlaylist", "TestUsername", "RemoveFromUsername");
        interactor.execute(inputData);
    }
}

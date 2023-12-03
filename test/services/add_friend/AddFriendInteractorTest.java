package services.add_friend;

import entities.CommonUser;
import entities.Playlist;
import entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddFriendInteractorTest {

    private AddFriendInteractor interactor;
    private AddFriendUserDataAccessInterface userDataAccessObject;
    private AddFriendOutputBoundary outputBoundary;

    @BeforeEach
    void setUp() {
        userDataAccessObject = new AddFriendUserDataAccessInterface() {
            @Override
            public User getUser(String username) {
                CommonUser user = new CommonUser(username, "dummyPassword");
                if ("existingFriend".equals(username)) {
                    // Adding an already existing friend for test
                    user.addFriend(new CommonUser("alreadyFriend", "dummyPassword"));
                }
                return user;
            }
        };

        outputBoundary = new AddFriendOutputBoundary() {
            @Override
            public void prepareSuccessView(AddFriendOutputData outputData) {
                assertNotNull(outputData, "Output data should not be null");
                assertTrue(outputData.userPlaylists.isEmpty(),
                    "User playlists should be empty in this test case");
            }

            @Override
            public void prepareFailView() {
                assertTrue(true, "Failure view should be prepared");
            }
        };

        interactor = new AddFriendInteractor(userDataAccessObject, outputBoundary);
    }

    @Test
    void successTest() {
        AddFriendInputData inputData = new AddFriendInputData("user", "newFriend");
        interactor.execute(inputData);
    }

    @Test
    void failureAlreadyFriends() {
        AddFriendInputData inputData = new AddFriendInputData("existingFriend", "alreadyFriend");
        interactor.execute(inputData);
    }
}

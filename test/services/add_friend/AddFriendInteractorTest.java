package services.add_friend;

import entities.CommonUser;
import entities.Playlist;
import entities.User;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class AddFriendInteractorTest {

    @Test
    void execute_SuccessfulAddFriend() {
        String friendUsername = "friend";
        String username = "user";
        User friend = new CommonUser(friendUsername, "password");
        User user = new CommonUser(username, "password");

        AddFriendUserDataAccessInterface userDataAccessObject = new AddFriendUserDataAccessInterface() {
            @Override
            public User getUser(String username) {
                if (username.equals(friendUsername)) {
                    return friend;
                } else if (username.equals(user.getUsername())) {
                    return user;
                }
                return null;
            }
        };

        AddFriendInputData inputData = new AddFriendInputData(friendUsername, username);

        AddFriendOutputBoundary outputBoundary = new AddFriendOutputBoundary() {
            @Override
            public void prepareSuccessView(AddFriendOutputData addFriendOutputData) {
                assertEquals(friendUsername, addFriendOutputData.username);
                assertFalse(addFriendOutputData.userPlaylists.isEmpty());
            }

            @Override
            public void prepareFailView() {
                fail("Failure is unexpected.");
            }
        };

        AddFriendInteractor interactor = new AddFriendInteractor(userDataAccessObject, outputBoundary);
        interactor.execute(inputData);
    }
}

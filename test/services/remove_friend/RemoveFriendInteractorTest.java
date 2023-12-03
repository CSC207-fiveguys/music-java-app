package services.remove_friend;

import static org.junit.jupiter.api.Assertions.*;

import entities.CommonUser;
import entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class RemoveFriendInteractorTest {

  private RemoveFriendInteractor interactor;
  private RemoveFriendDataAccessInterface userDataAccessObject;
  private RemoveFriendOutputBoundary outputBoundary;

  @BeforeEach
  void setUp() {
    userDataAccessObject = new RemoveFriendDataAccessInterface() {
      @Override
      public User getUser(String username) {
        CommonUser user = new CommonUser(username, "dummyPassword");
        if (username.equals("user")) {
          user.addFriend(new CommonUser("alreadyFriend", "dummyPassword"));
        }
        return user;

      }
    };

    outputBoundary = new RemoveFriendOutputBoundary() {
      @Override
      public void prepareSuccessView(RemoveFriendOutputData outputData) {
        assertNotNull(outputData, "Output data should not be null");
        assertTrue(outputData.userPlaylists.isEmpty(),
            "User playlists should be empty in this test case");
      }

      @Override
      public void prepareFailView() {
        assertTrue(true, "Failure view should be prepared");
      }
    };

    interactor = new RemoveFriendInteractor(userDataAccessObject, outputBoundary);

  }

  @Test
  void successTest() {
    RemoveFriendInputData inputData = new RemoveFriendInputData("user", "alreadyFriend");
    interactor.execute(inputData);
  }

  @Test
  void failureAlreadyFriends() {
    RemoveFriendInputData inputData = new RemoveFriendInputData("existingFriend", "newFriend");
    interactor.execute(inputData);
  }

}
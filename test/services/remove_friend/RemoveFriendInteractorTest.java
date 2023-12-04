package services.remove_friend;

import static org.junit.jupiter.api.Assertions.*;

import data_access.ArtistDataAccessObject;
import data_access.SpotifyDataAccessObject;
import data_access.TrackDataAccessObject;
import data_access.UserDataAccessObject;
import entities.CommonUser;
import entities.User;
import entities.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.add_friend.AddFriendInputBoundary;
import services.add_friend.AddFriendInputData;
import services.add_friend.AddFriendInteractor;
import services.add_friend.AddFriendOutputBoundary;
import services.add_friend.AddFriendOutputData;
import services.create_new_playlist.CreateNewPlaylistInteractor;
import services.create_new_playlist.CreateNewPlaylistOutputBoundary;
import services.create_new_playlist.CreateNewPlaylistOutputData;


class RemoveFriendInteractorTest {

  private RemoveFriendInteractor interactor;
  private RemoveFriendDataAccessInterface userDataAccessObject;
  private RemoveFriendOutputBoundary outputBoundary;

  @Test
  void successTest() {
    RemoveFriendInputData inputData = new RemoveFriendInputData("friendUsername", "username");
    UserFactory userFactory = new UserFactory();
    TrackDataAccessObject trackDataAccessObject = new TrackDataAccessObject();
    ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
    SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject(
        trackDataAccessObject, artistDataAccessObject);
    UserDataAccessObject userDataAccessInterface = new UserDataAccessObject(userFactory,
        spotifyDataAccessObject);
    User user = userFactory.create("friendUsername", "123");
    User user1 = userFactory.create("username", "123");
    userDataAccessInterface.saveUser(user);
    userDataAccessInterface.saveUser(user1);
    user1.addFriend(user);
    user.createPlaylist("Playlistname");
    RemoveFriendOutputBoundary removeFriendOutputBoundary = new RemoveFriendOutputBoundary() {
      @Override
      public void prepareSuccessView(RemoveFriendOutputData userFriends) {
        assertTrue(true, "should prepare success view");
        assertTrue(userFriends.userFriends.isEmpty(), "should be empty");
        assertTrue(userFriends.userPlaylists.isEmpty(), "should be empty");
      }

      @Override
      public void prepareFailView() {
        fail("Should not prepare fail");
      }
    };
    RemoveFriendInputBoundary removeFriendInputBoundary = new RemoveFriendInteractor(userDataAccessInterface, removeFriendOutputBoundary);
    removeFriendInputBoundary.execute(inputData);

  }

  @Test
  void failureTest() {
    RemoveFriendInputData inputData = new RemoveFriendInputData("friendUsername", "username");
    UserFactory userFactory = new UserFactory();
    TrackDataAccessObject trackDataAccessObject = new TrackDataAccessObject();
    ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
    SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject(
        trackDataAccessObject, artistDataAccessObject);
    UserDataAccessObject userDataAccessInterface = new UserDataAccessObject(userFactory,
        spotifyDataAccessObject);
    User user = userFactory.create("friendUsername", "123");
    userDataAccessInterface.saveUser(user);
    User user1 = userFactory.create("username", "123");
    userDataAccessInterface.saveUser(user1);
    RemoveFriendOutputBoundary removeFriendOutputBoundary = new RemoveFriendOutputBoundary() {
      @Override
      public void prepareSuccessView(RemoveFriendOutputData userFriends) {
        fail("Should not prepare success");
      }

      @Override
      public void prepareFailView() {
        assertTrue(true, "should prepare fail view");
      }
    };
    RemoveFriendInputBoundary removeFriendInputBoundary = new RemoveFriendInteractor(userDataAccessInterface, removeFriendOutputBoundary);
    removeFriendInputBoundary.execute(inputData);
  }
}

package services.add_friend;

import entities.Playlist;
import entities.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddFriendInteractor implements AddFriendInputBoundary {

  final AddFriendUserDataAccessInterface userDataAccessObject;
  final AddFriendOutputBoundary addFriendPresenter;

  public AddFriendInteractor(AddFriendUserDataAccessInterface userDataAccessObject,
      AddFriendOutputBoundary addFriendPresenter) {
    this.userDataAccessObject = userDataAccessObject;
    this.addFriendPresenter = addFriendPresenter;
  }

  @Override
  public void execute(AddFriendInputData addFriendInputData) {
    String friendUsername = addFriendInputData.friendUsername;
    User friend = userDataAccessObject.getUser(friendUsername);
    String username = addFriendInputData.username;
    User user = userDataAccessObject.getUser(username);
    ArrayList<User> userFriends = user.getFriends();

    if (userFriends.contains(friend)) {
      addFriendPresenter.prepareFailView();  // stay in the search tab
    } else {
      user.addFriend(friend);
      for (Playlist playlist : friend.getPlaylists()) {
        user.addPlaylist(playlist);
      }
      ArrayList<Map<String, String>> userPlaylists = new ArrayList<Map<String, String>>();
      for (Playlist playlist : user.getPlaylists()) {

        // Structure the output data
        Map<String, String> playlistAdded = new HashMap<>();
        playlistAdded.put(playlist.getName(), playlist.getOwner().getUsername());
        userPlaylists.add(playlistAdded);
      }
      AddFriendOutputData addFriendOutputData =
          new AddFriendOutputData(friendUsername, userPlaylists);
      addFriendPresenter.prepareSuccessView(addFriendOutputData);
    }
  }
}

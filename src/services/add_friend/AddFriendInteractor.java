package services.add_friend;

import entities.Playlist;
import entities.User;
import java.util.ArrayList;

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

    if (userFriends.contains(friend)){
      addFriendPresenter.prepareFailView
          (friendUsername + "is already your friend.");
    } else {
      // todo 1. add friend "friendUsername" to user "username"
      user.addFriend(friend);
      // todo 2. add playlists from "friendUsername" to user "username"
      for (Playlist playlist: user.getPlaylists()){
        user.addPlaylist(playlist);
      }
      AddFriendOutputData addFriendOutputData =
          new AddFriendOutputData(friendUsername);
      addFriendPresenter.prepareSuccessView(addFriendOutputData);
    }
  }
}

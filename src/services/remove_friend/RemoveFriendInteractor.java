package services.remove_friend;

import entities.Playlist;
import entities.User;
import java.util.ArrayList;
import java.util.Arrays;

public class RemoveFriendInteractor implements RemoveFriendInputBoundary{
  final RemoveFriendDataAccessInterface userDataAccessObject;
  final RemoveFriendOutputBoundary removeFriendPresenter;

  public RemoveFriendInteractor(RemoveFriendDataAccessInterface userDataAccessObject,
      RemoveFriendOutputBoundary removeFriendPresenter) {
    this.userDataAccessObject = userDataAccessObject;
    this.removeFriendPresenter = removeFriendPresenter;
  }

  @Override
  public void execute(RemoveFriendInputData removeFriendInputData) {
    String username = removeFriendInputData.username;
    User user = userDataAccessObject.getUser(username);
    String friendUsername = removeFriendInputData.friendUsername;
    User friendUser = userDataAccessObject.getUser(friendUsername);

    ArrayList<User> allFriends = user.getFriends();

    if (!allFriends.contains(friendUser)){
      removeFriendPresenter.prepareFailView();
    } else {
      user.removeFriend(friendUser);
      for (Playlist playlist: friendUser.getPlaylists()){
        if (user.getPlaylists().contains(playlist)){
          user.removePlaylist(playlist);
        }
      }
      // Create the output-data
      ArrayList<String> allFriendsStrings = new ArrayList<String>();
      for (User friend: allFriends){
        String name = friend.getUsername();
        allFriendsStrings.add(name);
      }
      RemoveFriendOutputData removeFriendOutputData =
          new RemoveFriendOutputData(allFriendsStrings);
      removeFriendPresenter.prepareSuccessView(removeFriendOutputData);
    }
  }
}

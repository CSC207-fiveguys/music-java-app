package services.remove_friend;

import entities.Playlist;
import java.util.ArrayList;
import java.util.Map;

public class RemoveFriendOutputData {
  public final ArrayList<String> userFriends;
  public final ArrayList<Map<String, String>> friendPlaylists;

  public RemoveFriendOutputData(
      ArrayList<String> userFriends,
      ArrayList<Map<String, String>> friendPlaylists) {
    this.userFriends = userFriends;
    this.friendPlaylists = friendPlaylists;
  }
}

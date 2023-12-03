package services.remove_friend;

import java.util.ArrayList;
import java.util.Map;

public class RemoveFriendOutputData {

  public final ArrayList<String> userFriends;
  public final ArrayList<Map<String, String>> userPlaylists;

  public RemoveFriendOutputData(
      ArrayList<String> userFriends,
      ArrayList<Map<String, String>> friendPlaylists) {
    this.userFriends = userFriends;
    this.userPlaylists = friendPlaylists;
  }
}

package services.add_friend;

import entities.Playlist;
import java.util.ArrayList;
import java.util.Map;

public class AddFriendOutputData {
  public final String username;
  public final ArrayList<Map<String, String>> userPlaylists;

  public AddFriendOutputData(String username, ArrayList<Map<String, String>> userPlaylists) {
    this.username = username;
    this.userPlaylists = userPlaylists;
  }

}

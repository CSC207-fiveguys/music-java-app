package entities;

import java.util.ArrayList;

public class PlaylistFactory {

  public Playlist create(String name, User owner, ArrayList<String> tracks) {
    return new CommonPlaylist(name, owner, tracks);
  }

}

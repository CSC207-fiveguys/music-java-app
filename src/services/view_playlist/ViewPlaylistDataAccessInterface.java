package services.view_playlist;

import entities.Playlist;
import entities.Track;
import entities.User;
import java.util.ArrayList;

public interface ViewPlaylistDataAccessInterface {

  Playlist getPlaylist(String playlistName, String username);

  User getUser(String username);

}

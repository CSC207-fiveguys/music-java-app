package services.view_playlist;

import entities.Playlist;
import entities.User;

public interface ViewPlaylistDataAccessInterface {

  Playlist getPlaylist(String playlistName, String username);

  User getUser(String username);

}

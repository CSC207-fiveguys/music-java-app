package services.view_playlist;

import entities.Playlist;
import entities.Track;
import java.util.ArrayList;

public interface ViewPlaylistDataAccessInterface {

  Playlist getPlaylist(String playlistName, String username);

}

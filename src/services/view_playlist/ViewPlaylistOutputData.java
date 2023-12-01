package services.view_playlist;

import entities.Playlist;
import entities.Track;
import java.util.ArrayList;

public class ViewPlaylistOutputData {

  public String playlistName;
  public boolean isShowingLikedTracks;
  public ArrayList<Track> tracks;

  ViewPlaylistOutputData(String playlistName, boolean isShowingLikedTracks, ArrayList<Track> tracks) {
    this.playlistName = playlistName;
    this.isShowingLikedTracks = isShowingLikedTracks;
    this.tracks = tracks;
  }

}

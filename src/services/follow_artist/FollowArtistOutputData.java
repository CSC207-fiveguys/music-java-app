package services.follow_artist;

import java.util.ArrayList;
import java.util.Map;

public class FollowArtistOutputData {

  public final ArrayList<Map<String, String>> artists;
  public final ArrayList<Map<String, String>> playlists;

  public FollowArtistOutputData(ArrayList<Map<String, String>> artists,
      ArrayList<Map<String, String>> playlists) {
    this.artists = artists;
    this.playlists = playlists;
  }
}

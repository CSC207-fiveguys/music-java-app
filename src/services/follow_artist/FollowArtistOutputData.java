package services.follow_artist;

import java.util.ArrayList;
import java.util.Map;

public class FollowArtistOutputData {
  public final ArrayList<Map<String, String>> artists;

  public FollowArtistOutputData(ArrayList<Map<String, String>> artists) {
    this.artists = artists;
  }
}

package services.unfollow_artist;

import java.util.ArrayList;
import java.util.Map;

public class UnfollowArtistOutputData {
  public final ArrayList<Map<String, String>> artists;

  public UnfollowArtistOutputData(ArrayList<Map<String, String>> artists) {
    this.artists = artists;
  }
}

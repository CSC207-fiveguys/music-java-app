package services.follow_artist;

import entities.Artist;
import entities.Track;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public interface FollowArtistSpotifyDataAccessInterface {

  public Track getTrack(JSONObject track);

  public Artist getArtist(JSONObject artist);
  public Artist getArtistID(String id);
  public ArrayList<String> getTopTracks(String id);
}

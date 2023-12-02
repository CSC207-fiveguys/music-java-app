package services.like_track;

import entities.Artist;
import entities.Track;
import java.util.ArrayList;
import org.json.JSONObject;

public interface LikeTrackSpotifyDataAccessInterface {
  ArrayList<Track> searchTrack(String id);
  Track getTrack(JSONObject track);
  ArrayList<Artist> searchArtist(String name);
  Artist getArtist(JSONObject artist);
  void saveTrack(String id);
  void saveArtist(String name);
}

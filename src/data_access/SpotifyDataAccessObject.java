package data_access;

import entities.Artist;
import entities.CommonArtist;
import entities.CommonTrack;
import entities.Track;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class SpotifyDataAccessObject {

  String accessToken;
  SpotifyAPI spotifyAPI;
  TrackDataAccessObject trackDataAccessObject;
  ArtistDataAccessObject artistDataAccessObject;

  public SpotifyDataAccessObject(TrackDataAccessObject trackDataAccessObject,
      ArtistDataAccessObject artistDataAccessObject) {
    spotifyAPI = new SpotifyAPI();
    accessToken = spotifyAPI.requestToken();
    this.trackDataAccessObject = trackDataAccessObject;
    this.artistDataAccessObject = artistDataAccessObject;
  }

  public ArrayList<Track> searchTrack(String query) {
    // Make the API call to search for Tracks matching the query
    // Return a list of the Track objects for the top 5 results
    try {

      JSONObject response = spotifyAPI.search_track(query, accessToken);

      // Extract the tracks from the api call
      JSONObject x = (JSONObject) response.get("tracks");
      JSONArray y = (JSONArray) x.get("items");

      ArrayList<Track> tracks = new ArrayList<>();
      // For each track returned by the call, save the track in our Track DAO
      for (Object track : y) {
        // Cast the track into a JSONObject (which is what it always will be)
        Track trackObject = saveTrack((JSONObject) track);
        tracks.add(trackObject);
      }

      return tracks;

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public Track saveTrack(JSONObject track) {
    // Create a new Track object and save it in the Track DAO using the data in track
    String id = (String) track.get("id");

    if (trackDataAccessObject.exists(id)) {
      // The Track already exists in our DAO then simply get it and return it
      return trackDataAccessObject.getTrack(id);
    } else {

      // If the Track object does not already exist in our DAO, create a new Track Object
      // Get all the fields needed
      String name = (String) track.get("name");
      int duration = (int) track.get("duration_ms");
      boolean explicit = (boolean) track.get("explicit");
      String artists = "";

      // Store all the artists in a String instead of a list
      JSONArray artistsList = (JSONArray) track.get("artists");
      for (Object artist : artistsList) {
        artists = artists.concat(((JSONObject) artist).get("name") + "   ");
      }

      String imageURL = null;

      // Store the image url if any images are given
      JSONArray images = (JSONArray) ((JSONObject) track.get("album")).get("images");
      if (!images.isEmpty()){
        imageURL = (String) ((JSONObject) images.get(0)).get("url");
      }

      Track trackObject = new CommonTrack(id, name, artists, duration, explicit, imageURL);
      trackDataAccessObject.saveTrack(trackObject);
      return trackObject;
    }
  }

  public ArrayList<Artist> searchArtist(String query) {
    try {
      JSONObject response = spotifyAPI.search_artist(query, accessToken);

      // Extract the tracks from the api call
      JSONObject x = (JSONObject) response.get("artists");
      JSONArray y = (JSONArray) x.get("items");

      ArrayList<Artist> artists = new ArrayList<>();
      // For each track returned by the call, save the track in our Track DAO
      for (Object artist : y) {
        // Cast the track into a JSONObject (which is what it always will be)
        Artist artistObject = saveArtist((JSONObject) artist);
        artists.add(artistObject);
      }
      return artists;

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public Artist saveArtist(JSONObject artist) {
    // Create a new Artist object and save it in the Artist DAO using the data in artist
    String id = (String) artist.get("id");

    if (artistDataAccessObject.exists(id)) {
      // The Track already exists in our DAO then simply get it and return it
      return artistDataAccessObject.getArtist(id);

    } else {
      // If the Track object does not already exist in our DAO, create a new Track Object
      // Get all the fields needed
      String name = (String) artist.get("name");
      int numFollowers = (int) ((JSONObject) artist.get("followers")).get("total");
      String imageURL = null;

      // Store the image url if any images are given
      JSONArray images = (JSONArray) artist.get("images");
      if (!images.isEmpty()){
        imageURL = (String) ((JSONObject) images.get(0)).get("url");
      }

      Artist artistObject = new CommonArtist(id, imageURL, name, numFollowers);
      artistDataAccessObject.saveArtist(artistObject);
      return artistObject;
    }
  }

}

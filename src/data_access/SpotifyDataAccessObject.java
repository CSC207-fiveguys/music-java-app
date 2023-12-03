package data_access;

import entities.Artist;
import entities.Track;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import services.follow_artist.FollowArtistSpotifyDataAccessInterface;
import services.search.SearchUserDataAccessInterface;
import services.add_track_to_playlist.AddTrackToPlaylistSpotifyDataAccessInterface;
import services.like_track.LikeTrackSpotifyDataAccessInterface;
import services.search.SearchUserDataAccessInterface;

public class SpotifyDataAccessObject implements
    SearchUserDataAccessInterface,
    AddTrackToPlaylistSpotifyDataAccessInterface,
    LikeTrackSpotifyDataAccessInterface,
    FollowArtistSpotifyDataAccessInterface
{

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
    JSONObject response = spotifyAPI.search_track(query, accessToken);

    // Extract the tracks from the api call
    JSONObject x = (JSONObject) response.get("tracks");
    JSONArray y = (JSONArray) x.get("items");

    ArrayList<Track> tracks = new ArrayList<>();
    // For each track returned by the call, create a Track object and store in list
    for (Object track : y) {
      // Cast the track into a JSONObject (which is what it always will be)
      Track trackObject = getTrack((JSONObject) track);
      tracks.add(trackObject);
      System.out.println(trackObject.getID());
    }

    return tracks;

  }

  public Track getTrack(JSONObject track) {
    // Create a new Track object using the data in track
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

      // Store the first given image url if any images are given
      JSONArray images = (JSONArray) ((JSONObject) track.get("album")).get("images");
      if (!images.isEmpty()){
        imageURL = (String) ((JSONObject) images.get(0)).get("url");
      }

      return trackDataAccessObject.trackFactory.create(id, name, artists, duration, explicit, imageURL);
    }
  }

  public ArrayList<Artist> searchArtist(String query) {
    JSONObject response = spotifyAPI.search_artist(query, accessToken);

    // Extract the tracks from the api call
    JSONObject x = (JSONObject) response.get("artists");
    JSONArray y = (JSONArray) x.get("items");

    ArrayList<Artist> artists = new ArrayList<>();
    // For each artist returned by the call, covert it into an Artist object and add it to the list
    for (Object artist : y) {
      // Cast the track into a JSONObject (which is what it always will be)
      Artist artistObject = getArtist((JSONObject) artist);
      artists.add(artistObject);
    }
    return artists;
  }

  public Artist getArtistID(String id) {
    // Create a new Artist object using the data in artist

    if (artistDataAccessObject.exists(id)) {
      // If the Artist already exists in our DAO then simply get it and return it
      return artistDataAccessObject.getArtist(id);

    } else {
      // If the Artist object does not already exist in our DAO, create a new Artist Object
      // Get all the fields needed

      saveArtist(id);
      return artistDataAccessObject.getArtist(id);
    }
  }

    public Artist getArtist(JSONObject artist) {
      // Create a new Artist object using the data in artist
      String id = (String) artist.get("id");

      if (artistDataAccessObject.exists(id)) {
        // If the Artist already exists in our DAO then simply get it and return it
        return artistDataAccessObject.getArtist(id);

      } else {
        // If the Artist object does not already exist in our DAO, create a new Artist Object
        // Get all the fields needed
        String name = (String) artist.get("name");
        int numFollowers = (int) ((JSONObject) artist.get("followers")).get("total");
        String imageURL = null;

        // Store the image url if any images are given
        JSONArray images = (JSONArray) artist.get("images");
        if (!images.isEmpty()){
          imageURL = (String) ((JSONObject) images.get(0)).get("url");
        }

        return artistDataAccessObject.artistFactory.create(id, imageURL, name, numFollowers);
      }
    }

  public void saveTrack(String id){
    if (!trackDataAccessObject.exists(id)){
      JSONObject track = spotifyAPI.get_track(id, accessToken);
      Track trackObject = getTrack(track);
      trackDataAccessObject.saveTrack(trackObject);
    }
  }

  public void saveArtist(String id){
    if (!artistDataAccessObject.exists(id)){
      JSONObject artist = spotifyAPI.get_artist(id, accessToken);
      Artist artistObject = getArtist(artist);
      artistDataAccessObject.saveArtist(artistObject);
    }
  }

  public ArrayList<String> getTopTracks(String id) {
    JSONObject x = spotifyAPI.get_artist_top_tracks(id, accessToken);
    JSONArray tracksArray = (JSONArray) x.get("tracks");

    ArrayList<String> tracks = new ArrayList<>();
    // For each track returned by the call, create a Track object and store in list
    for (Object track : tracksArray) {
      // Cast the track into a JSONObject (which is what it always will be)
      Track trackObject = getTrack((JSONObject) track);
      String trackID = trackObject.getID();
      tracks.add(trackID);
      if (!trackDataAccessObject.exists(trackID)) {
        trackDataAccessObject.saveTrack(trackObject);
      }
    }

    return tracks;
  }

}

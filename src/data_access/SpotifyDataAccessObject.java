package data_access;

import entities.Artist;
import entities.CommonTrack;
import entities.Track;

public class SpotifyDataAccessObject {

  String accessToken;
  spotifAPItemp spotifyAPI;
  TrackDataAccessObject trackDataAccessObject;
  ArtistDataAccessObject artistDataAccessObject;

  public SpotifyDataAccessObject(TrackDataAccessObject trackDataAccessObject,
      ArtistDataAccessObject artistDataAccessObject) {
    spotifyAPI = new spotifAPItemp();
    accessToken = spotifyAPI.requestToken();
    this.trackDataAccessObject = trackDataAccessObject;
    this.artistDataAccessObject = artistDataAccessObject;
  }

  public String search(String query) {
    try {
      String response = spotifAPItemp.search(query, accessToken);
      System.out.println(response);
      // TODO Get the id of the track/artist that we are looking for
      return null;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void saveTrack(String trackID) {
    // Make the API call to get the track using the id given
    // Create a new Track object and save it in the Track DAO
  }


  public void saveArtist(String ArtistID) {
    // Make the API call to get the Artist using the id given
    // Create a new Artist object and save it in the Artist DAO
  }
}

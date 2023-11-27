package services.search;

import entities.Artist;
import entities.Track;
import entities.User;
import java.awt.List;
import java.util.ArrayList;

public class SearchOutputData {

  private ArrayList<Artist> artists;
  private ArrayList<Track> tracks;
  private ArrayList<User> users;

  public SearchOutputData(ArrayList<Artist> artists, ArrayList<Track> tracks, ArrayList<User> users){
    this.artists = artists;
    this.tracks = tracks;
    this.users = users;
  }
}

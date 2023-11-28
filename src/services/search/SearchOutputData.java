package services.search;

import entities.Artist;
import entities.Track;
import entities.User;
import java.awt.List;
import java.util.ArrayList;

public class SearchOutputData {

   ArrayList<Artist> artists;
   ArrayList<Track> tracks;
   ArrayList<String> users;

  public SearchOutputData(ArrayList<Artist> artists, ArrayList<Track> tracks, ArrayList<String> users){
    this.artists = artists;
    this.tracks = tracks;
    this.users = users;
  }

}

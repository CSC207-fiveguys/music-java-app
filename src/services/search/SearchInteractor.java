package services.search;

import entities.Artist;
import entities.Track;
import entities.User;
import java.util.ArrayList;

public class SearchInteractor implements SearchInputBoundary{

  final SearchOutputBoundary SearchPresenter;
  final SearchUserDataAccessInterface SpotifyDataAccessObject;

  public SearchInteractor(SearchOutputBoundary SearchPresenter, SearchUserDataAccessInterface SpotifyDataAccessObject){
    this.SearchPresenter = SearchPresenter;
    this.SpotifyDataAccessObject = SpotifyDataAccessObject;
  }
  @Override
  public void execute(SearchInputData searchInputData) {
    String query = searchInputData.searchQuery;
    ArrayList<Artist> artists = new ArrayList<>();
    ArrayList<Track> tracks = new ArrayList<>();
    ArrayList<Track> users = new ArrayList<>();
    // Call the Spotify DAO to return a list of Tracks and Artists


  }
}

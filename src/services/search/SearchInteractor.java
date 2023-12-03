package services.search;

import data_access.UserDataAccessObject;
import entities.Artist;
import entities.Track;
import entities.User;
import java.util.ArrayList;

public class SearchInteractor implements SearchInputBoundary {

  final SearchOutputBoundary searchPresenter;
  final SearchUserDataAccessInterface spotifyDataAccessObject;
  final UserDataAccessObject userDataAccessObject;

  public SearchInteractor(SearchOutputBoundary SearchPresenter,
      SearchUserDataAccessInterface SpotifyDataAccessObject,
      UserDataAccessObject userDataAccessObject) {

    this.searchPresenter = SearchPresenter;
    this.spotifyDataAccessObject = SpotifyDataAccessObject;
    this.userDataAccessObject = userDataAccessObject;
  }
  @Override
  public void execute(SearchInputData searchInputData) {
    String query = searchInputData.searchQuery;
    // Call the Spotify DAO to return a list of Tracks and Artists
     ArrayList<Artist> artists = spotifyDataAccessObject.searchArtist(query);
     ArrayList<Track> tracks = spotifyDataAccessObject.searchTrack(query);
     ArrayList<String> users = searchInputData.searchAlgorithm.searchUser(query);

     // Create and return the Output Data
     SearchOutputData searchOutputData = new SearchOutputData(artists, tracks, users);
     searchPresenter.prepareSuccessView(searchOutputData);
  }

}

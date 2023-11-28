package services.search;

import entities.Artist;
import entities.Track;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import view.ViewManagerModel;
import view.logged_in.TabViewModel;
import view.logged_in.tabs.SearchViewModel;
import view.logged_in.tabs.SearchViewState;

public class SearchPresenter implements SearchOutputBoundary{

  private final SearchViewModel searchViewModel;


  public SearchPresenter(SearchViewModel searchViewModel){
    this.searchViewModel = searchViewModel;
  }
  @Override
  public void prepareSuccessView(SearchOutputData searchOutputData) {
    // Output Stuff
    SearchViewState state = searchViewModel.state;
    state.friendUsernames = searchOutputData.users;

    ArrayList<Map<String, Object>> tracks = new ArrayList<>();
    for (Track track: searchOutputData.tracks){
      // For each track, create a mapping to match the State output
      Map<String, Object> trackMap = new HashMap<>();
      trackMap.put("title", track.getName());
      trackMap.put("iconPath", track.getImageURL());
      trackMap.put("artists", track.getArtists());
      trackMap.put("explicit", track.isExplicit());
      int seconds = track.getDuration() / 1000;
      int minutes =  (seconds / 60);
      trackMap.put("duration", minutes  + ":" + String.format("%02d", seconds % 60));
      trackMap.put("id", track.getID());
      tracks.add(trackMap);
    }
    state.tracks = tracks;

    ArrayList<Map<String, String>> artists = new ArrayList<>();
    for (Artist artist: searchOutputData.artists){
      // For each artist, create a mapping that stores all the fields to match the State output
      Map<String, String> artistMap = new HashMap<>();
      artistMap.put("name", artist.getName());
      artistMap.put("followers", artist.getNumFollowers() + "");
      artistMap.put("iconPath", artist.getImageUrl());
      artistMap.put("id", artist.getID());
      artists.add(artistMap);
    }
    state.artists = artists;
    searchViewModel.firePropertyChanged();
  }

}

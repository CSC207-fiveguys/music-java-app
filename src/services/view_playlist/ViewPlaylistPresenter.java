package services.view_playlist;

import entities.Track;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import view.ViewManagerModel;
import view.logged_in.PlaylistViewModel;
import view.logged_in.PlaylistViewState;

public class ViewPlaylistPresenter implements ViewPlaylistOutputBoundary {

  private final PlaylistViewModel playlistViewModel;
  private final ViewManagerModel viewManagerModel;

  public ViewPlaylistPresenter(PlaylistViewModel playlistViewModel,
      ViewManagerModel viewManagerModel) {
    this.playlistViewModel = playlistViewModel;
    this.viewManagerModel = viewManagerModel;
  }

  @Override
  public void prepareSuccessView(ViewPlaylistOutputData viewPlaylistOutputData) {
    viewManagerModel.activeView = playlistViewModel.viewName;
    PlaylistViewState state = playlistViewModel.state;

    // Update the state attributes
    state.playlistName = viewPlaylistOutputData.playlistName;
    state.isShowingLikedTracks = viewPlaylistOutputData.isShowingLikedTracks;
    ArrayList<Track> trackArrayList = viewPlaylistOutputData.tracks;

    // Create a list storing Track inforamtion
    ArrayList<Map<String, Object>> tracks = new ArrayList<>();
    for (Track track: trackArrayList){
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
    playlistViewModel.firePropertyChanged();
    viewManagerModel.firePropertyChanged();
  }

}

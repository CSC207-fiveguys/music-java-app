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
    state.playlistName = viewPlaylistOutputData.playlistName;
    state.username = viewPlaylistOutputData.username;
    state.isShowingLikedTracks = viewPlaylistOutputData.isShowingLikedTracks;
    ArrayList<Track> trackArrayList = viewPlaylistOutputData.tracks;

    ArrayList<Map<String, Object>> tracks = new ArrayList<>();
    for (Track track: trackArrayList){
      Map<String, Object> trackMap = new HashMap<>();
      trackMap.put("title", track.getName());
      trackMap.put("iconPath", track.getImageURL());
      trackMap.put("artists", track.getArtists());
      trackMap.put("explicit", track.isExplicit());
      trackMap.put("duration", track.getDuration());
      trackMap.put("id", track.getID());
      tracks.add(trackMap);
    }
    state.tracks = tracks;
    playlistViewModel.firePropertyChanged();

  }
}

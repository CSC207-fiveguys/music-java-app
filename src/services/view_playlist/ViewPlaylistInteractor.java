package services.view_playlist;

import data_access.TrackDataAccessObject;
import entities.Playlist;
import entities.Track;
import java.util.ArrayList;

public class ViewPlaylistInteractor implements ViewPlaylistInputBoundary{

  final ViewPlaylistDataAccessInterface userDataAccessObject;
  final ViewPlaylistOutputBoundary viewPlaylistPresenter;

  final TrackDataAccessObject trackDataAccessObject;

  public ViewPlaylistInteractor(ViewPlaylistDataAccessInterface userDataAccessObject, ViewPlaylistOutputBoundary viewPlaylistPresenter,
      TrackDataAccessObject trackDataAccessObject) {
    this.userDataAccessObject = userDataAccessObject;
    this.viewPlaylistPresenter = viewPlaylistPresenter;
    this.trackDataAccessObject = trackDataAccessObject;
  }

  @Override
  public void execute(ViewPlaylistInputData viewPlaylistInputData) {
    // Get all the playlists from the UserDAO
    Playlist playlist = userDataAccessObject.getPlaylist(viewPlaylistInputData.playlistName, viewPlaylistInputData.username);
    // Get a list of Tracks from the playlist

    ArrayList<Track> tracks = new ArrayList<>();
    for (String trackID: playlist.getTracks()) {
      Track track = trackDataAccessObject.getTrack(trackID);
      tracks.add(track);
    }


    ViewPlaylistOutputData viewPlaylistOutputData = new ViewPlaylistOutputData(viewPlaylistInputData.username, viewPlaylistInputData.playlistName, viewPlaylistInputData.isShowingLikedTracks, tracks);

    viewPlaylistPresenter.prepareSuccessView(viewPlaylistOutputData);
  }

}

package services.view_playlist;

public class ViewPlaylistController {

    final ViewPlaylistInputBoundary viewPlaylistInteractor;

    public ViewPlaylistController(ViewPlaylistInputBoundary viewPlaylistInteractor) {
        this.viewPlaylistInteractor = viewPlaylistInteractor;
    }

    public void execute(String playlistName, String username, Boolean isShowingLikedTracks) {
        // todo 1. change PlaylistViewState
        // todo 2. change active view to PlaylistView
        ViewPlaylistInputData viewPlaylistInputData = new ViewPlaylistInputData(playlistName, username, isShowingLikedTracks);
        viewPlaylistInteractor.execute(viewPlaylistInputData);
    }

}

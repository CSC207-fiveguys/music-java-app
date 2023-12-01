package services.view_playlist;

public class ViewPlaylistController {

    final ViewPlaylistInputBoundary viewPlaylistInteractor;

    public ViewPlaylistController(ViewPlaylistInputBoundary viewPlaylistInteractor) {
        this.viewPlaylistInteractor = viewPlaylistInteractor;
    }

    public void execute(String playlistName, String username, Boolean isShowingLikedTracks) {
        ViewPlaylistInputData viewPlaylistInputData = new ViewPlaylistInputData(playlistName, username, isShowingLikedTracks);
        viewPlaylistInteractor.execute(viewPlaylistInputData);
    }

}

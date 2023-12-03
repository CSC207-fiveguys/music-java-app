package services.remove_track_from_playlist;

public class RemoveTrackFromPlaylistController {
    final RemoveTrackFromPlaylistInputBoundary removeTrackFromPlaylistInteractor;

    public RemoveTrackFromPlaylistController(RemoveTrackFromPlaylistInputBoundary removeTrackFromPlaylistInteractor) {
        this.removeTrackFromPlaylistInteractor = removeTrackFromPlaylistInteractor;
    }

    public void execute(String id, String username, String playlistName) {
        RemoveTrackFromPlaylistInputData removeTrackFromPlaylistInputData = new RemoveTrackFromPlaylistInputData(
                id, username, playlistName);

        removeTrackFromPlaylistInteractor.execute(removeTrackFromPlaylistInputData);
    }
}
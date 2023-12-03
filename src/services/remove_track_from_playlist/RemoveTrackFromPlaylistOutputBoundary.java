package services.remove_track_from_playlist;

public interface RemoveTrackFromPlaylistOutputBoundary {
    void prepareSuccessView(RemoveTrackFromPlaylistOutputData id);
    void prepareFailView();
}

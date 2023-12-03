package services.remove_track_from_liked;

public interface RemoveTrackFromLikedOutputBoundary {
    void prepareSuccessView(RemoveTrackFromLikedOutputData id);
    void prepareFailView();
}
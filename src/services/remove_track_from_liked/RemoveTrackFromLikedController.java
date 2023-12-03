package services.remove_track_from_liked;

public class RemoveTrackFromLikedController {
    final RemoveTrackFromLikedInputBoundary removeTrackFromLikedInteractor;

    public RemoveTrackFromLikedController(RemoveTrackFromLikedInputBoundary removeTrackFromLikedInteractor) {
        this.removeTrackFromLikedInteractor = removeTrackFromLikedInteractor;
    }

    public void execute(String id, String username) {
        RemoveTrackFromLikedInputData removeTrackFromLikedInputData = new
                RemoveTrackFromLikedInputData(id, username);

        removeTrackFromLikedInteractor.execute(removeTrackFromLikedInputData);
    }
}
package services.like_track;

public class LikeTrackController {
    final LikeTrackInputBoundary likeTrackInteractor;

    public LikeTrackController(LikeTrackInputBoundary likeTrackInteractor) {
        this.likeTrackInteractor = likeTrackInteractor;
    }

    public void execute(String id, String username) {
        LikeTrackInputData likeTrackInputData = new LikeTrackInputData(id, username);

        likeTrackInteractor.execute(likeTrackInputData);
    }
}

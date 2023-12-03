package services.remove_track_from_liked;

import entities.User;

public class RemoveTrackFromLikedInteractor implements RemoveTrackFromLikedInputBoundary {
    final RemoveTrackFromLikedUserDataAccessInterface userDataAccessObject;
    final RemoveTrackFromLikedOutputBoundary removeTrackFromLikedPresenter;

    public RemoveTrackFromLikedInteractor(
            RemoveTrackFromLikedUserDataAccessInterface userDataAccessObject,
            RemoveTrackFromLikedOutputBoundary removeTrackFromLikedPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.removeTrackFromLikedPresenter = removeTrackFromLikedPresenter;
    }

    public void execute(RemoveTrackFromLikedInputData removeTrackFromLikedInputData) {
        String id = removeTrackFromLikedInputData.id;
        String username = removeTrackFromLikedInputData.username;

        User user = userDataAccessObject.getUser(username);

        user.getLikedTracks().removeTrack(id);

        RemoveTrackFromLikedOutputData removeTrackFromLikedOutputData = new
                RemoveTrackFromLikedOutputData(id);

        removeTrackFromLikedPresenter.prepareSuccessView(removeTrackFromLikedOutputData);
    }
}
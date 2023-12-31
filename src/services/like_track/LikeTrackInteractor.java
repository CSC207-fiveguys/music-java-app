package services.like_track;

import entities.Playlist;
import entities.User;
import java.util.ArrayList;

public class LikeTrackInteractor implements LikeTrackInputBoundary {
    final LikeTrackUserDataAccessInterface userDataAccessObject;
    final LikeTrackSpotifyDataAccessInterface spotifyDataAccessObject;
    final LikeTrackOutputBoundary likeTrackPresenter;

    public LikeTrackInteractor(LikeTrackUserDataAccessInterface userDataAccessObject,
                               LikeTrackSpotifyDataAccessInterface spotifyDataAccessObject,
                               LikeTrackOutputBoundary likeTrackPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.spotifyDataAccessObject = spotifyDataAccessObject;
        this.likeTrackPresenter = likeTrackPresenter;
    }

    public void execute(LikeTrackInputData likeTrackInputData) {
        String id = likeTrackInputData.id;
        String username = likeTrackInputData.username;

        User user = userDataAccessObject.getUser(username);

        Playlist playlist = user.getLikedTracks();

        if (!playlist.getTracks().contains(id)) {
            spotifyDataAccessObject.saveTrack(id);
            playlist.addTrack(id);
            likeTrackPresenter.prepareSuccessView();
        }
    }
}

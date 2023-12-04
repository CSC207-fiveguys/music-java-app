package services.like_track;

import static org.junit.jupiter.api.Assertions.*;

import data_access.ArtistDataAccessObject;
import data_access.SpotifyDataAccessObject;
import data_access.TrackDataAccessObject;
import data_access.UserDataAccessObject;
import entities.Track;
import entities.TrackFactory;
import entities.User;
import entities.UserFactory;
import org.junit.jupiter.api.Test;

class LikeTrackControllerTest {

    @Test
    void execute() {
        TrackDataAccessObject trackDataAccessObject = new TrackDataAccessObject();
        ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
        SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject);
        UserFactory userFactory = new UserFactory();
        TrackFactory trackFactory = new TrackFactory();
        UserDataAccessObject userDataAccessInterface = new UserDataAccessObject(userFactory, spotifyDataAccessObject);
        LikeTrackInputBoundary inputBoundary = new LikeTrackInteractor(
            userDataAccessInterface, spotifyDataAccessObject, new LikeTrackOutputBoundary() {
            @Override
            public void prepareSuccessView() {
                assertTrue(true, "should prepare success");
            }
            @Override
            public void prepareFailView() {
                fail("should not prepare failure");
            }
        });

        LikeTrackController likeTrackController = new LikeTrackController(inputBoundary);
        User user = userFactory.create("user", "123");
        Track track = trackFactory.create("123", "track", "artist", 100, false, "url");
        userDataAccessInterface.saveUser(user);
        trackDataAccessObject.saveTrack(track);
        user.likeTrack("123");
        likeTrackController.execute("123", "user");
    }
}
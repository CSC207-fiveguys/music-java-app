package services.remove_track_from_liked;

import static org.junit.jupiter.api.Assertions.*;

import data_access.ArtistDataAccessObject;
import data_access.SpotifyDataAccessObject;
import data_access.TrackDataAccessObject;
import data_access.UserDataAccessObject;
import entities.Artist;
import entities.ArtistFactory;
import entities.Track;
import entities.TrackFactory;
import entities.User;
import entities.UserFactory;
import org.junit.jupiter.api.Test;
import services.unfollow_artist.UnfollowArtistController;
import services.unfollow_artist.UnfollowArtistInputBoundary;
import services.unfollow_artist.UnfollowArtistInteractor;
import services.unfollow_artist.UnfollowArtistOutputBoundary;
import services.unfollow_artist.UnfollowArtistOutputData;

class RemoveTrackFromLikedControllerTest {

    @Test
    void execute() {
        TrackDataAccessObject trackDataAccessObject = new TrackDataAccessObject();
        ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
        SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject);
        UserFactory userFactory = new UserFactory();
        TrackFactory trackFactory = new TrackFactory();
        UserDataAccessObject userDataAccessInterface = new UserDataAccessObject(userFactory, spotifyDataAccessObject);
        RemoveTrackFromLikedInputBoundary inputBoundary = new RemoveTrackFromLikedInteractor(
            userDataAccessInterface, new RemoveTrackFromLikedOutputBoundary() {
            @Override
            public void prepareSuccessView(RemoveTrackFromLikedOutputData outputData) {
                assertTrue(true, "should prepare success");
            }
            @Override
            public void prepareFailView() {
                fail("should not prepare failure");
            }
        });

        RemoveTrackFromLikedController removeTrackFromLikedController = new RemoveTrackFromLikedController(inputBoundary);
        User user = userFactory.create("user", "123");
        Track track = trackFactory.create("123", "track", "artist", 100, false, "url");
        userDataAccessInterface.saveUser(user);
        trackDataAccessObject.saveTrack(track);
        user.likeTrack("123");
        removeTrackFromLikedController.execute("123", "user");
    }
}
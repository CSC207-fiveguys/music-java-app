package services.remove_track_from_liked;

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
import services.back_to_tab_view.BackToTabViewInteractor;
import services.back_to_tab_view.BackToTabViewOutputBoundary;
import services.remove_playlist.RemovePlaylistDataAccessInterface;

class RemoveTrackFromLikedInteractorTest {

    @Test
    void successTest() {
        RemoveTrackFromLikedInputData removeTrackFromLikedInputData = new RemoveTrackFromLikedInputData("1234", "username");
        UserFactory userFactory = new UserFactory();
        TrackFactory trackFactory = new TrackFactory();
        TrackDataAccessObject trackDataAccessObject  = new TrackDataAccessObject();
        ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
        SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject);
        UserDataAccessObject userDataAccessInterface = new UserDataAccessObject(userFactory, spotifyDataAccessObject);
        Track track = trackFactory.create("1234", "song", "artist", 1234, false, "url");
        User user1 = userFactory.create("username", "123");
        userDataAccessInterface.saveUser(user1);
        trackDataAccessObject.saveTrack(track);
        user1.likeTrack("1234");

        RemoveTrackFromLikedOutputBoundary removeTrackFromLikedOutputBoundary = new RemoveTrackFromLikedOutputBoundary() {
            @Override
            public void prepareSuccessView(RemoveTrackFromLikedOutputData id) {
                assertTrue(user1.getLikedTracks().getTracks().isEmpty(), "Test case should be empty");
            }

            @Override
            public void prepareFailView() {
                fail("Should not present fail");
            }
        };
        RemoveTrackFromLikedInputBoundary removeTrackFromLikedInteractor = new RemoveTrackFromLikedInteractor(userDataAccessInterface, removeTrackFromLikedOutputBoundary);
        removeTrackFromLikedInteractor.execute(removeTrackFromLikedInputData);
    }
}
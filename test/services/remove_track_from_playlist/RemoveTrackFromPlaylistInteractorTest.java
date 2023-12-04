package services.remove_track_from_playlist;

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
import services.remove_track_from_liked.RemoveTrackFromLikedInteractor;

class RemoveTrackFromPlaylistInteractorTest {

    @Test
    void successTest() {
        RemoveTrackFromPlaylistInputData removeTrackFromPlaylistInputData = new RemoveTrackFromPlaylistInputData("1234", "user", "playlistname");
        UserFactory userFactory = new UserFactory();
        TrackFactory trackFactory = new TrackFactory();
        TrackDataAccessObject trackDataAccessObject  = new TrackDataAccessObject();
        ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
        SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject);
        UserDataAccessObject userDataAccessInterface = new UserDataAccessObject(userFactory, spotifyDataAccessObject);
        Track track = trackFactory.create("1234", "song", "artist", 1234, false, "url");
        User user1 = userFactory.create("user", "123");
        userDataAccessInterface.saveUser(user1);
        user1.createPlaylist("playlistname");
        trackDataAccessObject.saveTrack(track);
        user1.addTrackToPlaylist("1234", "playlistname");

        RemoveTrackFromPlaylistOutputBoundary removeTrackFromPlaylistOutputBoundary = new RemoveTrackFromPlaylistOutputBoundary() {
            @Override
            public void prepareSuccessView(RemoveTrackFromPlaylistOutputData id) {
                assertTrue(user1.getPlaylists().isEmpty(), "Test case should be empty");
            }

            @Override
            public void prepareFailView() {
                fail("Should not present fail");
            }
        };

        RemoveTrackFromPlaylistInputBoundary removeTrackFromPlaylistInteractor = new RemoveTrackFromPlaylistInteractor(userDataAccessInterface, removeTrackFromPlaylistOutputBoundary);
        removeTrackFromPlaylistInteractor.execute(removeTrackFromPlaylistInputData);
    }
}
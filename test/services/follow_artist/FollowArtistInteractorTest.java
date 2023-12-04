package services.follow_artist;

import data_access.ArtistDataAccessObject;
import data_access.SpotifyDataAccessObject;
import data_access.TrackDataAccessObject;
import data_access.UserDataAccessObject;
import entities.Artist;
import entities.CommonArtist;
import entities.CommonUser;
import entities.Playlist;
import entities.User;
import entities.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class FollowArtistInteractorTest {

    private FollowArtistInteractor interactor;
    private FollowArtistSpotifyDataAccessInterface spotifyDataAccessObject;
    private FollowArtistDataAccessInterface artistDataAccessObject;
    private FollowArtistUserDataAccessInterface userDataAccessObject;
    private FollowArtistOutputBoundary outputBoundary;

    @BeforeEach
    void setUp() {
        TrackDataAccessObject trackDataAccessObject = new TrackDataAccessObject();
        ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
        SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject);
        UserFactory userFactory = new UserFactory();

        spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject) {
            @Override
            public ArrayList<String> getTopTracks(String artistId) {
                ArrayList<String> topTracks = new ArrayList<>();
                topTracks.add("Track 1");
                return topTracks;
            }

            @Override
            public Artist getArtistID(String artistId) {
                return new CommonArtist("Artist 1", "imageURL", "1", 1000);
            }
        };

        artistDataAccessObject = new ArtistDataAccessObject() {
            // Implement any required methods
        };

        userDataAccessObject = new UserDataAccessObject(userFactory, spotifyDataAccessObject) {
            @Override
            public User getUser(String username) {
                return new CommonUser(username, "dummyPassword");
            }
        };

        outputBoundary = new FollowArtistOutputBoundary() {
            @Override
            public void prepareSuccessView(FollowArtistOutputData outputData) {
                assertNotNull(outputData, "Output data should not be null");
                assertFalse(outputData.artists.isEmpty(), "Artists list should not be empty");
                assertFalse(outputData.playlists.isEmpty(), "Playlists list should not be empty");
            }
        };

        interactor = new FollowArtistInteractor(spotifyDataAccessObject, artistDataAccessObject, userDataAccessObject, outputBoundary);
    }

    @Test
    void successTest() {
        FollowArtistInputData inputData = new FollowArtistInputData("user", "artistId");
        interactor.execute(inputData);
    }
}

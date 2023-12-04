package services.search;

import data_access.ArtistDataAccessObject;
import data_access.SpotifyDataAccessObject;
import data_access.TrackDataAccessObject;
import data_access.UserDataAccessObject;
import entities.Artist;
import entities.CommonArtist;
import entities.CommonTrack;
import entities.Track;
import entities.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class SearchInteractorTest {

    private SearchInteractor interactor;
    private SearchUserDataAccessInterface spotifyDataAccessObject;
    private UserDataAccessObject userDataAccessObject;
    private SearchOutputBoundary outputBoundary;

    @BeforeEach
    void setUp() {
        TrackDataAccessObject trackDataAccessObject = new TrackDataAccessObject();
        ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
        SpotifyDataAccessObject spotifyDataAccessObject1 = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject);
        UserFactory userFactory = new UserFactory();
        spotifyDataAccessObject = new SearchUserDataAccessInterface() {
            @Override
            public ArrayList<Artist> searchArtist(String query) {
                ArrayList<Artist> artists = new ArrayList<>();
                artists.add(new CommonArtist("12341234", "google.com" , "Artist1", 12345)); // Assuming Artist constructor
                return artists;
            }

            @Override
            public ArrayList<Track> searchTrack(String query) {
                ArrayList<Track> tracks = new ArrayList<>();
                tracks.add(new CommonTrack("12341234", "Track1", "Artist1", 12345, true, "google.com")); // Assuming Track constructor
                return tracks;
            }
        };

        userDataAccessObject = new UserDataAccessObject(userFactory, spotifyDataAccessObject1) {
            @Override
            public ArrayList<String> searchUser(String query) {
                ArrayList<String> users = new ArrayList<>();
                users.add("User1");
                return users;
            }
        };

        outputBoundary = new SearchOutputBoundary() {
            @Override
            public void prepareSuccessView(SearchOutputData outputData) {
                assertNotNull(outputData, "Output data should not be null");
                assertFalse(outputData.artists.isEmpty(), "Artist list should not be empty");
                assertFalse(outputData.tracks.isEmpty(), "Track list should not be empty");
                assertFalse(outputData.users.isEmpty(), "User list should not be empty");
            }
        };

        interactor = new SearchInteractor(outputBoundary, spotifyDataAccessObject, userDataAccessObject);
    }

    @Test
    void successTest() {
        SearchInputData inputData = new SearchInputData("query");
        interactor.execute(inputData);
    }
}

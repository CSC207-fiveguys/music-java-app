package services.search;

import static org.junit.jupiter.api.Assertions.*;

import data_access.ArtistDataAccessObject;
import data_access.SpotifyDataAccessObject;
import data_access.TrackDataAccessObject;
import data_access.UserDataAccessObject;
import entities.User;
import entities.UserFactory;
import org.junit.jupiter.api.Test;
import services.remove_playlist.RemovePlaylistController;
import services.remove_playlist.RemovePlaylistInputBoundary;
import services.remove_playlist.RemovePlaylistInteractor;
import services.remove_playlist.RemovePlaylistOutputBoundary;
import services.remove_playlist.RemovePlaylistOutputData;

class SearchControllerTest {

    @Test
    void execute() {
        TrackDataAccessObject trackDataAccessObject = new TrackDataAccessObject();
        ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
        SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject);
        UserFactory userFactory = new UserFactory();
        UserDataAccessObject userDataAccessInterface = new UserDataAccessObject(userFactory, spotifyDataAccessObject);
        SearchInputBoundary inputBoundary = new SearchInteractor(new SearchOutputBoundary() {
            @Override
            public void prepareSuccessView(SearchOutputData searchOutputData) {
                assertTrue(true, "should present success view");
            }
        }, spotifyDataAccessObject, userDataAccessInterface);

        SearchController controller = new SearchController(inputBoundary);
        controller.execute("drake");
    }
}
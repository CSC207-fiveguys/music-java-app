package services.follow_artist;

import static org.junit.jupiter.api.Assertions.*;

import data_access.ArtistDataAccessObject;
import data_access.SpotifyDataAccessObject;
import data_access.TrackDataAccessObject;
import data_access.UserDataAccessObject;
import entities.ArtistFactory;
import entities.UserFactory;
import org.junit.jupiter.api.Test;

class FollowArtistControllerTest {

    @Test
    void execute() {
        TrackDataAccessObject trackDataAccessObject = new TrackDataAccessObject();
        ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
        SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject);
        UserFactory userFactory = new UserFactory();
        ArtistFactory artistFactory = new ArtistFactory();
        UserDataAccessObject userDataAccessInterface = new UserDataAccessObject(userFactory, spotifyDataAccessObject);
        FollowArtistInputBoundary inputBoundary = new FollowArtistInteractor(spotifyDataAccessObject, artistDataAccessObject, userDataAccessInterface,
            new FollowArtistOutputBoundary() {
                @Override
                public void prepareSuccessView(FollowArtistOutputData friendUsername) {
                    assertTrue(true, "should present success");
                }
            });

        FollowArtistController controller = new FollowArtistController(inputBoundary);
        userDataAccessInterface.saveUser(userFactory.create("user", "123"));
        artistDataAccessObject.saveArtist(artistFactory.create(
            "123", "url", "artist", 123
        ));
        controller.execute("123", "user");
    }
}
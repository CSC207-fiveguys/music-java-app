package services.unfollow_artist;

import static org.junit.jupiter.api.Assertions.*;

import data_access.ArtistDataAccessObject;
import data_access.SpotifyDataAccessObject;
import data_access.TrackDataAccessObject;
import data_access.UserDataAccessObject;
import entities.Artist;
import entities.ArtistFactory;
import entities.User;
import entities.UserFactory;
import org.junit.jupiter.api.Test;

class UnfollowArtistInteractorTest {

    private UnfollowArtistInteractor interactor;
    private UnfollowArtistDataAccessInterface userDataAccessObject;
    private UnfollowArtistOutputBoundary outputBoundary;

    @Test
    void successTest() {
        UnfollowArtistInputData inputData = new UnfollowArtistInputData("1234", "username");
        UserFactory userFactory = new UserFactory();
        ArtistFactory artistFactory = new ArtistFactory();
        TrackDataAccessObject trackDataAccessObject = new TrackDataAccessObject();
        ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
        SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject(
            trackDataAccessObject, artistDataAccessObject);
        UserDataAccessObject userDataAccessInterface = new UserDataAccessObject(userFactory,
            spotifyDataAccessObject);
        Artist artist = artistFactory.create("1234", "url", "artist", 10);
        User user1 = userFactory.create("username", "123");
        artistDataAccessObject.saveArtist(artist);
        userDataAccessInterface.saveUser(user1);
        user1.followArtist("1234");
        UnfollowArtistOutputBoundary unfollowArtistOutputBoundary = new UnfollowArtistOutputBoundary() {
            @Override
            public void prepareSuccessView(UnfollowArtistOutputData userArtists) {
                assertTrue(true, "should prepare success view");
                assertTrue(user1.getFollowedArtists().isEmpty());
            }
        };
        UnfollowArtistInputBoundary unfollowArtistInteractor = new UnfollowArtistInteractor(artistDataAccessObject, userDataAccessInterface, unfollowArtistOutputBoundary);
        unfollowArtistInteractor.execute(inputData);

    }
}
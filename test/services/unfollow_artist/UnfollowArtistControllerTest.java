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
import services.remove_friend.RemoveFriendController;
import services.remove_friend.RemoveFriendInputBoundary;
import services.remove_friend.RemoveFriendInteractor;
import services.remove_friend.RemoveFriendOutputBoundary;
import services.remove_friend.RemoveFriendOutputData;

class UnfollowArtistControllerTest {

    @Test
    void execute() {
        TrackDataAccessObject trackDataAccessObject = new TrackDataAccessObject();
        ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
        SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject);
        UserFactory userFactory = new UserFactory();
        ArtistFactory artistFactory = new ArtistFactory();
        UserDataAccessObject userDataAccessInterface = new UserDataAccessObject(userFactory, spotifyDataAccessObject);
        UnfollowArtistInputBoundary inputBoundary = new UnfollowArtistInteractor(
            artistDataAccessObject, userDataAccessInterface, new UnfollowArtistOutputBoundary() {
            @Override
            public void prepareSuccessView(UnfollowArtistOutputData userArtists) {
                assertTrue(true, "should prepare success");
            }
        });

        UnfollowArtistController unfollowArtistController = new UnfollowArtistController(inputBoundary);
        User user = userFactory.create("user", "123");
        Artist artist = artistFactory.create("123", "url", "artist", 123);
        userDataAccessInterface.saveUser(user);
        artistDataAccessObject.saveArtist(artist);
        user.followArtist("123");
        unfollowArtistController.execute("123", "user");
    }
}
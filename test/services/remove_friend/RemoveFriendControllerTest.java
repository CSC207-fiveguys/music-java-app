package services.remove_friend;

import static org.junit.jupiter.api.Assertions.*;

import data_access.ArtistDataAccessObject;
import data_access.SpotifyDataAccessObject;
import data_access.TrackDataAccessObject;
import data_access.UserDataAccessObject;
import entities.User;
import entities.UserFactory;
import org.junit.jupiter.api.Test;
import services.add_friend.AddFriendController;
import services.add_friend.AddFriendInputBoundary;
import services.add_friend.AddFriendInteractor;
import services.add_friend.AddFriendOutputBoundary;
import services.add_friend.AddFriendOutputData;
import services.remove_playlist.RemovePlaylistController;

class RemoveFriendControllerTest {

    @Test
    void execute() {
        TrackDataAccessObject trackDataAccessObject = new TrackDataAccessObject();
        ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
        SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject);
        UserFactory userFactory = new UserFactory();
        UserDataAccessObject userDataAccessInterface = new UserDataAccessObject(userFactory, spotifyDataAccessObject);
        RemoveFriendInputBoundary inputBoundary = new RemoveFriendInteractor(
            userDataAccessInterface, new RemoveFriendOutputBoundary() {
            @Override
            public void prepareSuccessView(RemoveFriendOutputData userFriends) {
                assertTrue(true, "should prepare success");
            }

            @Override
            public void prepareFailView() {
                fail("should not prepare fail");
            }
        });

        RemoveFriendController removeFriendcontroller = new RemoveFriendController(inputBoundary);
        User user = userFactory.create("user", "123");
        User friendUsername = userFactory.create("friendUsername", "123");
        userDataAccessInterface.saveUser(user);
        userDataAccessInterface.saveUser(friendUsername);
        user.addFriend(friendUsername);
        removeFriendcontroller.execute("friendUsername", "user");

    }
}
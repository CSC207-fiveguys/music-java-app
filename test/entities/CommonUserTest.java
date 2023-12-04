package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class CommonUserTest {

    private CommonUser user;
    private final String testTrackID = "track123";
    private final String testPlaylistName = "Test Playlist";
    private final String testArtistID = "artist123";
    private CommonUser friend;

    @BeforeEach
    void setUp() {
        user = new CommonUser("username", "password");
        friend = new CommonUser("friendname", "friendpassword"); // Assuming a similar constructor for friends
    }

    @Test
    void getUsername() {
        assertEquals("username", user.getUsername(), "getUsername should return the correct username.");
    }

    @Test
    void getPassword() {
        assertEquals("password", user.getPassword(), "getPassword should return the correct password.");
    }

    @Test
    void getLikedTracks() {
        assertNotNull(user.getLikedTracks(), "getLikedTracks should not return null.");
    }

    @Test
    void likeTrack() {
        // TODO: Implement when addTracktoPlaylists is implemented
    }

    @Test
    void unlikeTrack() {
        // TODO: Implement when addTracktoPlaylists is implemented
    }

    @Test
    void getPlaylists() {
        assertNotNull(user.getPlaylists(), "getPlaylists should not return null.");
    }

    @Test
    void createPlaylist() {
        user.createPlaylist(testPlaylistName);
        assertTrue(user.getPlaylists().stream().anyMatch(playlist -> playlist.getName().equals(testPlaylistName)), "createPlaylist should add a new playlist.");
    }

    @Test
    void addTrackToPlaylist() {
        // TODO: Implement this test after completing addTrackToPlaylist method
    }

    @Test
    void removeTrackFromPlaylist() {
        // TODO: Implement this test after completing removeTrackFromPlaylist method
    }

    @Test
    void getFollowedArtists() {
        assertNotNull(user.getFollowedArtists(), "getFollowedArtists should not return null.");
    }

    @Test
    void followArtist() {
        user.followArtist(testArtistID);
        assertTrue(user.getFollowedArtists().contains(testArtistID), "followArtist should add an artist to followed artists.");
    }

    @Test
    void unfollowArtist() {
        user.followArtist(testArtistID);
        user.unfollowArtist(testArtistID);
        assertFalse(user.getFollowedArtists().contains(testArtistID), "unfollowArtist should remove an artist from followed artists.");
    }

    @Test
    void getFriends() {
        assertNotNull(user.getFriends(), "getFriends should not return null.");
    }

    @Test
    void addFriend() {
        user.addFriend(friend);
        assertTrue(user.getFriends().contains(friend), "addFriend should add a friend to the user's friends list.");
    }

    @Test
    void removeFriend() {
        user.addFriend(friend);
        user.removeFriend(friend);
        assertFalse(user.getFriends().contains(friend), "removeFriend should remove a friend from the user's friends list.");
    }

    @Test
    void addPlaylist() {
        Playlist newPlaylist = new PlaylistFactory().create(testPlaylistName, user, new ArrayList<>());
        user.addPlaylist(newPlaylist);
        assertTrue(user.getPlaylists().contains(newPlaylist), "addPlaylist should add a playlist to the user's playlists.");
    }

}

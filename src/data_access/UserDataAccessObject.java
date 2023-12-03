package data_access;

import entities.Playlist;
import entities.User;
import entities.UserFactory;
import java.util.ArrayList;

import services.add_track_to_playlist.AddTrackToPlaylistUserDataAccessInterface;
import services.like_track.LikeTrackUserDataAccessInterface;
import services.login_complete.LoginCompleteUserDataAccessInterface;
import services.remove_track_from_liked.RemoveTrackFromLikedUserDataAccessInterface;
import services.remove_track_from_playlist.RemoveTrackFromPlaylistUserDataAccessInterface;

import services.add_friend.AddFriendUserDataAccessInterface;
import services.create_new_playlist.CreateNewPlaylistDataAccessInterface;
import services.follow_artist.FollowArtistUserDataAccessInterface;
import services.remove_friend.RemoveFriendDataAccessInterface;
import services.remove_playlist.RemovePlaylistDataAccessInterface;
import services.signup_complete.SignupCompleteUserDataAccessInterface;


import java.util.HashMap;
import java.util.Map;
import services.unfollow_artist.UnfollowArtistUserDataAccessInterface;
import services.view_playlist.ViewPlaylistDataAccessInterface;

public class UserDataAccessObject implements

      LoginCompleteUserDataAccessInterface,
      SignupCompleteUserDataAccessInterface,
      CreateNewPlaylistDataAccessInterface,
      RemovePlaylistDataAccessInterface,
      ViewPlaylistDataAccessInterface,
      AddFriendUserDataAccessInterface,
      RemoveFriendDataAccessInterface,
      AddTrackToPlaylistUserDataAccessInterface,
      UnfollowArtistUserDataAccessInterface,
      LikeTrackUserDataAccessInterface,
      FollowArtistUserDataAccessInterface,
      RemoveTrackFromPlaylistUserDataAccessInterface,
      RemoveTrackFromLikedUserDataAccessInterface {

    public final Map<String, User> users;

    public final UserFactory userFactory;

    public UserDataAccessObject(UserFactory userFactory, SpotifyDataAccessObject spotifyDataAccessObject) {
      this.userFactory = userFactory;
      users = new HashMap<>();

      User fake_user = userFactory.create("bob445", "bananaPASS");
      users.put(fake_user.getUsername(), fake_user);
      fake_user.createPlaylist("gym beats for real");
      spotifyDataAccessObject.saveTrack("6DCZcSspjsKoFjzjrWoCdn");
      fake_user.addTrackToPlaylist("6DCZcSspjsKoFjzjrWoCdn", "gym beats for real");
      spotifyDataAccessObject.saveTrack("29TPjc8wxfz4XMn21O7VsZ");
      fake_user.addTrackToPlaylist("29TPjc8wxfz4XMn21O7VsZ", "gym beats for real");
      spotifyDataAccessObject.saveTrack("3yII7UwgLF6K5zW3xad3MP");
      fake_user.addTrackToPlaylist("3yII7UwgLF6K5zW3xad3MP", "gym beats for real");
      spotifyDataAccessObject.saveTrack("2xLMifQCjDGFmkHkpNLD9h");
      fake_user.addTrackToPlaylist("2xLMifQCjDGFmkHkpNLD9h", "gym beats for real");
      spotifyDataAccessObject.saveTrack("7ijBEjJrD2hoKF19huAFhI");
      fake_user.addTrackToPlaylist("7ijBEjJrD2hoKF19huAFhI", "gym beats for real");
      spotifyDataAccessObject.saveTrack("7hMHrXdWKN3Kv4IO0sxCD0");
      fake_user.addTrackToPlaylist("7hMHrXdWKN3Kv4IO0sxCD0", "gym beats for real");
    }

    public User getUser(String username) {
      return users.get(username);
    }

    public void saveUser(User user) {
      // Add the user to the dictionary and then update the json file
      users.put(user.getUsername(), user);
      save();
    }

    public boolean exists(String username) {
      return users.containsKey(username);
    }

    private void save() {
      // Write the user data from users to the json file
      // TODO Implement this method
    }

    @Override
    public Playlist getPlaylist(String playlistName, String username) {
      // Return the Playlist with the given name belonging to the given user
      User user = users.get(username);
      for (Playlist playlist : user.getPlaylists()) {
        if (playlist.getName().equals(playlistName)) {
          return playlist;
        }
      }
      return null; // This line should never be reached as the playlist name will be valid
    }


}

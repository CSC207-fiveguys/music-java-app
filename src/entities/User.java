package entities;

import java.util.ArrayList;

public interface User {

    String getUsername();

    String getPassword();

    Playlist getLikedTracks();

     void likeTrack(String trackID);

    void unlikeTrack(String trackID);

    ArrayList<Playlist> getPlaylists();

    void createPlaylist(String playlistName);

    void addTrackToPlaylist(String trackID, String playlistName);

    void removeTrackFromPlaylist(String trackID, String playlistName);

    ArrayList<String> getFollowedArtists();

    void followArtist(String artistID);

    void unfollowArtist(String artistID);

    ArrayList<User> getFriends();

     void addFriend(User friend);

     void removeFriend(User friend);

}

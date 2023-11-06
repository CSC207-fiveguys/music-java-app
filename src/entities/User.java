package entities;

import java.util.ArrayList;

public interface User {

    String getUsername();

    String getPassword();

    Playlist getLikedTracks();

    ArrayList<Playlist> getPlaylists();

    ArrayList<Artist> getFollowedArtists();

    ArrayList<User> getFriends();

}

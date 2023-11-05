package entities;

import java.util.ArrayList;

public class CommonUser implements User{
    private final String name;
    private final String password;
    private final Playlist likedTracks;
    private final ArrayList<Playlist> personalPlaylists;
    private final ArrayList<Artist> followedArtists;
    private final ArrayList<User> friends;

    /**
     * Requires: password is valid.
     * @param name
     * @param password
     */
    CommonUser(String name, String password){
        this.name = name;
        this.password = password;
        // DESIGN CHOICE: WHEN CREATING USERS, THEY WILL NOT HAVE ANY FILLED IN ATTRIBUTES OTHER THAN USERNAME/PASSWORD
        // THESE ATTRIBUTES WILL GET FILLED IN WHEN THE USER MAKES CERTAIN ACTIONS (LIKING TRACKS, ADDING FRIENDS ETC.)
        this.likedTracks = new CommonPlaylist("Liked Tracks", this, new ArrayList<Track>());
        this.personalPlaylists = new ArrayList<Playlist>();
        this.followedArtists = new ArrayList<Artist>();
        this.friends = new ArrayList<User>();

    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Playlist getLikedTracks() {
        return likedTracks;
    }

    @Override
    public ArrayList<Playlist> getPlaylists() {
        return personalPlaylists;
    }

    @Override
    public ArrayList<Artist> getFollowedArtists() {
        return followedArtists;
    }

    @Override
    public ArrayList<User> getFriends() {
        return friends;
    }
}

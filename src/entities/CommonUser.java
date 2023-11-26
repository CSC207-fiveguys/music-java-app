package entities;

import java.util.ArrayList;

public class CommonUser implements User {
    private final String username;
    private final String password;
    private final Playlist likedTracks;
    private final ArrayList<Playlist> personalPlaylists;
    private final ArrayList<String> followedArtists;
    private final ArrayList<User> friends;

    /**
     * Requires: password is valid.
     * @param username This is the User's username that they signed up with
     * @param password This is their password that the signed up with
     */
    public CommonUser(String username, String password) {
        this.username = username;
        this.password = password;
        // DESIGN CHOICE 1: WHEN CREATING USERS, THEY WILL NOT HAVE ANY FILLED IN ATTRIBUTES OTHER THAN USERNAME/PASSWORD
        // THESE ATTRIBUTES WILL GET FILLED IN WHEN THE USER MAKES CERTAIN ACTIONS (LIKING TRACKS, ADDING FRIENDS ETC.)

        // Design Choice 2: Instead of storing Tracks and Artists, we will store their ids. These ids will act as
        // keys in the cache dictionary, and the values will be the actual Track or Artist objects. This is done
        // to reduce API calls.
        this.likedTracks = new CommonPlaylist("Liked Tracks", this, new ArrayList<String>());
        this.personalPlaylists = new ArrayList<Playlist>();
        this.followedArtists = new ArrayList<String>();
        this.friends = new ArrayList<User>();

    }
    @Override
    public String getUsername() {
        return username;
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
    public void likeTrack(String trackID){
        addTrackToPlaylist(trackID, "Liked Tracks");
    }

    @Override
    public void unlikeTrack(String trackID){
        removeTrackFromPlaylist(trackID, "Liked Tracks");
    }

    @Override
    public ArrayList<Playlist> getPlaylists() {
        return personalPlaylists;
    }

    @Override
    public void createPlaylist(String playlistName){
        Playlist newPlaylist = new CommonPlaylist(playlistName, this, new ArrayList<String>());
        personalPlaylists.add(newPlaylist);
    }

    // TODO Fill in the bodies of addTrackToPlaylist() and removeTrackFromPlaylist()
    @Override
    public void addTrackToPlaylist(String trackID, String playlistName){return;}

    @Override
    public void removeTrackFromPlaylist(String trackID, String playlistName){return;}
    @Override
    public ArrayList<String> getFollowedArtists() {
        return followedArtists;
    }

    @Override
    public void followArtist(String artistID){
        followedArtists.add(artistID);
    }

    @Override
    public void unfollowArtist(String artistID){
        followedArtists.remove(artistID);
    }

    @Override
    public ArrayList<User> getFriends() {
        return friends;
    }

    @Override
    public void addFriend(User friend){
        friends.add(friend);
    }

    @Override
    public void removeFriend(User friend){
        friends.remove(friend);
    }

}

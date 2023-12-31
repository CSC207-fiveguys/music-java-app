package data_access;

import entities.Artist;

import entities.ArtistFactory;
import java.util.HashMap;
import java.util.Map;
import services.follow_artist.FollowArtistDataAccessInterface;
import services.unfollow_artist.UnfollowArtistDataAccessInterface;

public class ArtistDataAccessObject implements
    UnfollowArtistDataAccessInterface,
    FollowArtistDataAccessInterface {

    private final Map<String, Artist> artists;
    public final ArtistFactory artistFactory;

    public ArtistDataAccessObject() {
        // The DataAccessObject stores the artist ids and Artist objects of all the artists that we
        // have gotten from the Spotify API so far. This is to reduce API calls and prevent
        // having duplicate objects for the same artist.
        // This data is kept in a json file
        artists = new HashMap<>();
        artistFactory = new ArtistFactory();
        // TODO: Read from the json file that stores the Artist data and store it in artists
    }

    public Artist getArtist(String artistID) {
        return artists.get(artistID);
    }

    public void saveArtist(Artist artist) {
        // Add the artist to the dictionary and then update the json file
        artists.put(artist.getID(), artist);
        save();
    }

    public boolean exists(String artistID) {
        return artists.containsKey(artistID);
    }

    private void save() {
        // Write the current Artist data in artists to the json file
        // TODO Implement this method
    }

}
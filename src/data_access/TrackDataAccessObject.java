package data_access;

import entities.Track;

import entities.TrackFactory;
import java.util.HashMap;
import java.util.Map;

public class TrackDataAccessObject {

    private final Map<String, Track> tracks;

    public final TrackFactory trackFactory;

    public TrackDataAccessObject() {
        // The DataAccessObject stores the track ids and Track objects of all the tracks that we
        // have gotten from the Spotify API so far. This is to reduce API calls and prevent
        // having duplicate objects for the same track.
        // This data is kept in a json file
        tracks = new HashMap<>();
        trackFactory = new TrackFactory();

        // TODO: Read from the json file that stores Track Data
    }

    public Track getTrack(String trackID) {
        return tracks.get(trackID);
    }

    public void saveTrack(Track track) {
        // Add the track to the dictionary and then update the json file
        tracks.put(track.getID(), track);
        save();
    }

    public boolean exists(String trackID) {
        return tracks.containsKey(trackID);
    }

    private void save() {
        // Write the current Track data in tracks to the json file
        // TODO Implement this method
    }

}

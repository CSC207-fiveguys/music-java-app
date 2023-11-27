package entities;

import java.util.ArrayList;

public class CommonPlaylist implements Playlist {

    private final String name;
    private final User owner;
    // Design Choice: Playlists will contain a list of String track ids, which serve as the
    // keys in our cache dictionary, which actually stores the Track object
    private final ArrayList<String> tracks;

    public CommonPlaylist(String name, User owner, ArrayList<String> tracks) {
        this.name = name;
        this.owner = owner;
        this.tracks = tracks;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public User getOwner() {
        return owner;
    }

    @Override
    public ArrayList<String> getTracks() {
        return tracks;
    }

    @Override
    public void addTrack(String trackID) {
        tracks.add(trackID);
    }

    @Override
    public void removeTrack(String trackID) {
        tracks.remove(trackID);
    }

}

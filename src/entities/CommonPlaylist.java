package entities;

import java.util.ArrayList;

public class CommonPlaylist implements Playlist {

    private final String name;
    private final User owner;
    private final ArrayList<Track> tracks;

    CommonPlaylist(String name, User owner, ArrayList<Track> tracks) {
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
    public ArrayList<Track> getTracks() {
        return tracks;
    }
}

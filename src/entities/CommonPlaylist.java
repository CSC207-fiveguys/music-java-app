package entities;

import java.util.ArrayList;

public class CommonPlaylist implements Playlist{

    private final String name;
    private final User user;
    private final ArrayList<Track> tracks;

    CommonPlaylist(String name, User user, ArrayList<Track> tracks) {
        this.name = name;
        this.user = user;
        this.tracks = tracks;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public ArrayList<Track> getTracks() {
        return tracks;
    }
}

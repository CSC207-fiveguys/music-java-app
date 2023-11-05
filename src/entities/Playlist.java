package entities;

import java.util.ArrayList;

public interface Playlist {

    String getName();

    User getUser();

    ArrayList<Track> getTracks();
}

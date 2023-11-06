package entities;

import java.util.ArrayList;

public interface Playlist {

    String getName();

    User getOwner();

    ArrayList<Track> getTracks();
}

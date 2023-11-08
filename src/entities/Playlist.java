package entities;

import java.util.ArrayList;

public interface Playlist {

    String getName();

    User getOwner();

    ArrayList<String> getTracks();

    void addTrack(String trackID);

    void removeTrack(String trackID);

}

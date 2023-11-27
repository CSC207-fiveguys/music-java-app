package entities;

public interface Track {

    String getID();

    String getName();

    String getArtists();

    int getDuration();

    boolean isExplicit();

    String getImageURL();

}

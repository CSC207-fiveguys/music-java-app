package services.search;

import entities.Artist;
import entities.Track;
import java.util.ArrayList;

public interface SearchUserDataAccessInterface {

  ArrayList<Artist> searchArtist(String query);

  ArrayList<Track> searchTrack(String query);
}

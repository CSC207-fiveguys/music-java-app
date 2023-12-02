package services.unfollow_artist;

import entities.Artist;
import java.util.HashMap;

public interface FollowArtistDataAccessInterface {


  public Artist getArtist(String artistID);

  public void saveArtist(Artist artist);

  public boolean exists(String artistID);

  private void save() {

  }

}

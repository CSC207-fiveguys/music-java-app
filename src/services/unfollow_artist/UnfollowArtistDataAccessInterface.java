package services.unfollow_artist;

import entities.Artist;

public interface UnfollowArtistDataAccessInterface {

  public Artist getArtist(String artistID);

  public void saveArtist(Artist artist);

  public boolean exists(String artistID);
}

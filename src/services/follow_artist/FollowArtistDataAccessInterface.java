package services.follow_artist;

import entities.Artist;

public interface FollowArtistDataAccessInterface {
  public Artist getArtist(String artistID);

  public void saveArtist(Artist artist);

  public boolean exists(String artistID);

  private void save() {

  }
}

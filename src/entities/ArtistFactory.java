package entities;

public class ArtistFactory {

  public Artist create(String id, String imageURL, String name, int numFollowers){
    return new CommonArtist(id, imageURL, name, numFollowers);
  }

}
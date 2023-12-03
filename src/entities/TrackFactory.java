package entities;

public class TrackFactory {

  public Track create(String id, String name, String artists, int duration, boolean explicit, String imageURL) {
    return new CommonTrack(id, name, artists, duration, explicit, imageURL);
  }

}
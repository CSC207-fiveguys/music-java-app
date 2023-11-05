package entities;

public class CommonTrack implements Track{
    String id;
    String imageURL;
    String name;
    String artists;
    int duration;

    CommonTrack(String id, String imageURL, String name, String artists, int duration){
        this.id = id;
        this.imageURL = imageURL;
        this.name = name;
        this.artists = artists;
        this.duration = duration;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public String getImageURL() {
        return imageURL;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getArtists() {
        return artists;
    }

    @Override
    public int getDuration() {
        return duration;
    }
}

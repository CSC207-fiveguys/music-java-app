package entities;

public class CommonTrack implements Track{
    final String id;
    final String imageURL;
    final String name;
    final String artists;
    int duration;
    final boolean explicit;

    CommonTrack(String id, String imageURL, String name, String artists, int duration, boolean explicit){
        this.id = id;
        this.imageURL = imageURL;
        this.name = name;
        this.artists = artists;
        this.duration = duration;
        this.explicit = explicit;
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

    @Override
    public boolean getExplicit() {
        return explicit;
    }
}

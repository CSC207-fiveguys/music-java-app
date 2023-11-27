package entities;

public class CommonTrack implements Track {
    private final String id;
    private final String name;
    private final String artists;
    private final int duration;

    private final String imageURL;
    private final boolean explicit;

    public CommonTrack(String id, String name, String artists, int duration, boolean explicit, String imageURL) {
        this.id = id;
        this.name = name;
        this.artists = artists;
        this.duration = duration;
        this.explicit = explicit;
        this.imageURL = imageURL;
    }

    @Override
    public String getID() {
        return id;
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
    public boolean isExplicit() {
        return explicit;
    }

    @Override
    public String getImageURL(){return imageURL;}

}

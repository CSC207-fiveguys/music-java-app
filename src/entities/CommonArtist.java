package entities;

public class CommonArtist implements Artist {

    private final String id;
    private final String imageURL;
    private final String name;
    private final int numFollowers;

    public CommonArtist(String id, String imageURL, String name, int numFollowers) {
        this.id = id;
        this.imageURL = imageURL;
        this.name = name;
        this.numFollowers = numFollowers;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public String getImageUrl() {
        return imageURL;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getNumFollowers() {
        return numFollowers;
    }

}
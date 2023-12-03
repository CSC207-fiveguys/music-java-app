package services.remove_playlist;

public class RemovePlaylistInputData {

    public final String playlistName;
    public final String ownerUsername;
    public final String removeFromUsername;

    public RemovePlaylistInputData(String playlistName, String ownerUsername,
        String removeFromUsername) {
        this.playlistName = playlistName;
        this.ownerUsername = ownerUsername;
        this.removeFromUsername = removeFromUsername;
    }

}

package services.create_new_playlist;

public class CreateNewPlaylistInputData {

    public final String playlistName;
    public final String username;

    public CreateNewPlaylistInputData(String playlistName, String username) {
        this.playlistName = playlistName;
        this.username = username;
    }

}

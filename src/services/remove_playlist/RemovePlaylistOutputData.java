package services.remove_playlist;

public class RemovePlaylistOutputData {

    public final String playlistname;
    public final String username;

    public RemovePlaylistOutputData(String playlistname, String username) {
        this.playlistname = playlistname;
        this.username = username;
    }
}

package services.add_track_to_playlist;

public class AddTrackToPlaylistInputData {

    public final String id;
    public final String username;
    public final String playlistName;

    public AddTrackToPlaylistInputData(String id, String username, String playlistName) {
        this.id = id;
        this.username = username;
        this.playlistName = playlistName;
    }

}

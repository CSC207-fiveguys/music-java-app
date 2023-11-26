package services.remove_track_from_playlist;

public class RemoveTrackFromPlaylistInputData {

    public final String id;
    public final String username;
    public final String playlistName;

    public RemoveTrackFromPlaylistInputData(String id, String username, String playlistName) {
        this.id = id;
        this.username = username;
        this.playlistName = playlistName;
    }

}

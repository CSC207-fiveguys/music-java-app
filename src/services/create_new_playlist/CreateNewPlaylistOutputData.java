package services.create_new_playlist;

import entities.Playlist;
import java.util.ArrayList;
import java.util.Map;

public class CreateNewPlaylistOutputData {
    public final String username;
    public final String playlistname;
    public final ArrayList<Map<String, Object>> tracks;

    public CreateNewPlaylistOutputData(String username, String playlistname, ArrayList<Map<String, Object>> tracks) {
        this.username = username;
        this.playlistname = playlistname;
        this.tracks = tracks;
    }
}

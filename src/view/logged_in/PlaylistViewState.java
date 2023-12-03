package view.logged_in;

import java.util.ArrayList;
import java.util.Map;

public class PlaylistViewState {
    public String username;
    public String playlistName;
    public Boolean isShowingLikedTracks;
    public ArrayList<Map<String, Object>> tracks;
    // map keys should be:
    // String "title"
    // String "iconPath"
    // String "artists"
    // Boolean "explicit"
    // String "duration"
    // String "id"

    public PlaylistViewState() {
        // defines default state for testing purposes
        username = null;
        playlistName = null;
        isShowingLikedTracks = true;

        tracks = new ArrayList<>();

        Map<String, Object> track1 = Map.of(
                "title", "track1_title",
                "iconPath", "https://i.imgur.com/RoLe4Hv.jpeg",
                "artists", "Da Baby Shark, et al.",
                "explicit", true,
                "duration", "3:21",
                "id", "1abc"
        );

        Map<String, Object> track2 = Map.of(
                "title", "track2_title",
                "iconPath", "https://i.imgur.com/0rt8ejM.jpeg",
                "artists", "tiger woods",
                "explicit", false,
                "duration", "2:20",
                "id", "2abc"
        );

        Map<String, Object> track3 = Map.of(
                "title", "track3_title",
                "iconPath", "https://i.imgur.com/ufc2y.jpeg",
                "artists", "uoft",
                "explicit", true,
                "duration", "1:11",
                "id", "3abc"
        );

//        tracks.add(track1);
//        tracks.add(track2);
//        tracks.add(track3);
    }
}

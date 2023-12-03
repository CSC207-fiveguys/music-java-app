package view.logged_in.tabs;

import java.util.ArrayList;
import java.util.Map;

public class SearchViewState {
    public String username;
    public final String searchButtonText = "search";

    public ArrayList<Map<String, Object>> tracks;
    // map keys should be:
    // String "title"
    // String "iconPath"
    // String "artists"
    // Boolean "explicit"
    // String "duration"
    // String "id"

    public ArrayList<Map<String, String>> artists;
    // map keys should be:
    // String "name"
    // String "followers"
    // String "iconPath"
    // String "id"

    public ArrayList<String> users;

    public SearchViewState() {
        // defines default state for testing purposes
        username = null;

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

        tracks.add(track1);
        tracks.add(track2);
        tracks.add(track3);

        artists = new ArrayList<>();

        Map<String, String> artist1 = Map.of(
                "name", "artist1",
                "followers", "923,234",
                "iconPath", "https://i.imgur.com/93WebmM.jpeg",
                "id", "a-x"
        );

        Map<String, String> artist2 = Map.of(
                "name", "artist2",
                "followers", "83,111",
                "iconPath", "https://i.imgur.com/I8tXjGj.jpeg",
                "id", "a-y"
        );

        Map<String, String> artist3 = Map.of(
                "name", "artist3",
                "followers", "342",
                "iconPath", "https://i.imgur.com/LX7LQYO.png",
                "id", "a-z"
        );

        artists.add(artist1);
        artists.add(artist2);
        artists.add(artist3);

        users = new ArrayList<>();
        users.add("friend1");
        users.add("friend2");
        users.add("friend3");
    }
}

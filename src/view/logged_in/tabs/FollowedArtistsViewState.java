package view.logged_in.tabs;

import java.util.ArrayList;
import java.util.Map;

public class FollowedArtistsViewState {
    public String username;
    public ArrayList<Map<String, String>> artists;
    // map keys should be:
    // String "name"
    // String "followers"
    // String "iconPath"
    // String "id"


    public FollowedArtistsViewState() {
        // defines default state for testing purposes
        username = null;

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
    }
}

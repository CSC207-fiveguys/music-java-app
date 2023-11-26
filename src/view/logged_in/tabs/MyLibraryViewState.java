package view.logged_in.tabs;

import java.util.ArrayList;
import java.util.Map;

public class MyLibraryViewState {
    public String username;
    public final String newPlaylistNameText = "new playlist name:";
    public final String newPlaylistButtonText = "create new playlist";
    public ArrayList<Map<String, String>> personalPlaylists;
    // map keys should be:
    // String "title"
    // String "owner"

    public MyLibraryViewState() {
        // defines default state for testing purposes
        username = null;

        personalPlaylists = new ArrayList<>();

        Map<String, String> playlist1 = Map.of(
                "title", "playlist1",
                "owner", "owner1"
        );

        Map<String, String> playlist2 = Map.of(
                "title", "playlist2",
                "owner", "owner2"
        );

        Map<String, String> playlist3 = Map.of(
                "title", "playlist3",
                "owner", "owner3"
        );

        personalPlaylists.add(playlist1);
        personalPlaylists.add(playlist2);
        personalPlaylists.add(playlist3);
    }


}

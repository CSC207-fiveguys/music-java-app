package view.logged_in.tabs;

import java.util.ArrayList;


public class FollowedFriendsViewState {
    public String username;
    public ArrayList<String> friendUsernames;

    public FollowedFriendsViewState() {
        // defines default state for testing purposes
        username = null;
        friendUsernames = new ArrayList<>();
        friendUsernames.add("friend1");
        friendUsernames.add("friend2");
        friendUsernames.add("friend3");
    }
}

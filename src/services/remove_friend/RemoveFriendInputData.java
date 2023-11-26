package services.remove_friend;

public class RemoveFriendInputData {

    public final String friendUsername;
    public final String username;

    public RemoveFriendInputData(String friendUsername, String username) {
        this.friendUsername = friendUsername;
        this.username = username;
    }

}

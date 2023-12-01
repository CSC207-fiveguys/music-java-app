package services.add_friend;

public class AddFriendController {

    private final AddFriendInputBoundary addFriendInteractor;

    public AddFriendController(AddFriendInputBoundary addFriendInteractor) {
        this.addFriendInteractor = addFriendInteractor;
    }

    public void execute(String friendUsername, String username) {
        // todo 1. add friend "friendUsername" to user "username"
        // todo 2. add playlists from "friendUsername" to user "username"
        AddFriendInputData addFriendInputData =
            new AddFriendInputData(friendUsername, username);

        this.addFriendInteractor.execute(addFriendInputData);
    }
}

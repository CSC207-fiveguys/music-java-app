package services.remove_friend;

public class RemoveFriendController {

  private final RemoveFriendInputBoundary removeFriendInteractor;

  public RemoveFriendController(RemoveFriendInputBoundary removeFriendInteractor) {
    this.removeFriendInteractor = removeFriendInteractor;
  }

  public void execute(String friendUsername, String username) {
    // todo 1. remove friend "friendUsername" to user "username"
    // todo 2. remove playlists from "friendUsername" to user "username"
    RemoveFriendInputData removeFriendInputData =
        new RemoveFriendInputData(friendUsername, username);
    removeFriendInteractor.execute(removeFriendInputData);
  }
}

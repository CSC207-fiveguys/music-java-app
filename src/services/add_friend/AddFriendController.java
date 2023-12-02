package services.add_friend;

public class AddFriendController {

  private final AddFriendInputBoundary addFriendInteractor;

  public AddFriendController(AddFriendInputBoundary addFriendInteractor) {
    this.addFriendInteractor = addFriendInteractor;
  }

  public void execute(String friendUsername, String username) {
    AddFriendInputData addFriendInputData =
        new AddFriendInputData(friendUsername, username);

    this.addFriendInteractor.execute(addFriendInputData);
  }
}

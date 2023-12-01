package services.remove_friend;

public class RemoveFriendInteractor implements RemoveFriendInputBoundary{
  final RemoveFriendDataAccessInterface userDataAccessObject;
  final RemoveFriendOutputBoundary removeFriendPresenter;

  public RemoveFriendInteractor(RemoveFriendDataAccessInterface userDataAccessObject,
      RemoveFriendOutputBoundary removeFriendPresenter) {
    this.userDataAccessObject = userDataAccessObject;
    this.removeFriendPresenter = removeFriendPresenter;
  }

  @Override
  public void execute(RemoveFriendInputData removeFriendInputData) {
  }
}

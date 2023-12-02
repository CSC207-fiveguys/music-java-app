package services.remove_friend;

public interface RemoveFriendOutputBoundary {

  void prepareSuccessView(RemoveFriendOutputData userFriends);

  void prepareFailView();

}

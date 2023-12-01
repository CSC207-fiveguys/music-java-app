package services.add_friend;

public interface AddFriendOutputBoundary {

  void prepareSuccessView(AddFriendOutputData friendsPlaylists);
  void prepareFailView(String error);

}

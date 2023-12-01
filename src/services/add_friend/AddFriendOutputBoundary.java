package services.add_friend;

public interface AddFriendOutputBoundary {

  void prepareSuccessView(AddFriendOutputData friendUsername);
  void prepareFailView(String error);

}

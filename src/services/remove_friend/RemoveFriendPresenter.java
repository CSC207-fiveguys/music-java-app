package services.remove_friend;

import java.util.ArrayList;
import view.ViewManagerModel;
import view.logged_in.tabs.FollowedFriendsViewModel;
import view.logged_in.tabs.FollowedFriendsViewState;

public class RemoveFriendPresenter implements RemoveFriendOutputBoundary {

  private final FollowedFriendsViewModel followedFriendsViewModel;
  private final ViewManagerModel viewManagerModel;

  public RemoveFriendPresenter(FollowedFriendsViewModel followedFriendsViewModel,
      ViewManagerModel viewManagerModel) {
    this.followedFriendsViewModel = followedFriendsViewModel;
    this.viewManagerModel = viewManagerModel;
  }

  @Override
  public void prepareSuccessView(RemoveFriendOutputData userFriends) {
    FollowedFriendsViewState followedFriendsViewState = followedFriendsViewModel.state;
    followedFriendsViewState.friendUsernames = userFriends.userFriends;
    followedFriendsViewModel.firePropertyChanged();
  }


  @Override
  public void prepareFailView() {
    FollowedFriendsViewState followedFriendsViewState = followedFriendsViewModel.state;
    followedFriendsViewModel.firePropertyChanged();

  }
}

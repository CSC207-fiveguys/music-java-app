package services.add_friend;

import view.ViewManagerModel;
import view.logged_in.tabs.FollowedFriendsView;
import view.logged_in.tabs.FollowedFriendsViewModel;
import view.logged_in.tabs.FollowedFriendsViewState;
import view.logged_in.tabs.MyLibraryViewModel;
import view.logged_in.tabs.SearchViewModel;

public class AddFriendPresenter implements AddFriendOutputBoundary {
  private final FollowedFriendsViewModel followedFriendsViewModel;
  private final SearchViewModel searchViewModel;
  private ViewManagerModel viewManagerModel;


  public AddFriendPresenter(
      FollowedFriendsViewModel followedFriendsViewModel,
      SearchViewModel searchViewModel,
      ViewManagerModel viewManagerModel) {
    this.followedFriendsViewModel = followedFriendsViewModel;
    this.searchViewModel = searchViewModel;
    this.viewManagerModel = viewManagerModel;
  }
  public void prepareSuccessView(AddFriendOutputData friendUsername){
    FollowedFriendsViewState followedFriendsViewState = followedFriendsViewModel.state;
    followedFriendsViewState.username = friendUsername.username;
    this.followedFriendsViewModel.firePropertyChanged();

    this.viewManagerModel.activeView = followedFriendsViewModel.viewName;
    this.viewManagerModel.firePropertyChanged();

  }
  public void prepareFailView(String error){
    FollowedFriendsViewState followedFriendsViewState = followedFriendsViewModel.state;
    followedFriendsViewState.error = error;
  }
}

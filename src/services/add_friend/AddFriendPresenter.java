package services.add_friend;

import view.ViewManagerModel;
import view.logged_in.tabs.FollowedFriendsView;
import view.logged_in.tabs.FollowedFriendsViewModel;
import view.logged_in.tabs.FollowedFriendsViewState;
import view.logged_in.tabs.MyLibraryViewModel;
import view.logged_in.tabs.SearchViewModel;
import view.logged_in.tabs.SearchViewState;

public class AddFriendPresenter implements AddFriendOutputBoundary {
  private final SearchViewModel searchViewModel;
  private final FollowedFriendsViewModel followedFriendsViewModel;
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
    SearchViewState searchViewState = searchViewModel.state;
    searchViewModel.firePropertyChanged();

    FollowedFriendsViewState followedFriendsViewState = followedFriendsViewModel.state;
    followedFriendsViewState.friendUsernames.add(friendUsername.username);
    followedFriendsViewModel.firePropertyChanged();
  }


  public void prepareFailView(String error){
    SearchViewState searchViewState = searchViewModel.state;
    searchViewModel.firePropertyChanged();
  }
}

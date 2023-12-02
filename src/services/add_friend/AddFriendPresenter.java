package services.add_friend;

import view.ViewManagerModel;
import view.logged_in.tabs.FollowedFriendsViewModel;
import view.logged_in.tabs.FollowedFriendsViewState;
import view.logged_in.tabs.MyLibraryViewModel;
import view.logged_in.tabs.MyLibraryViewState;
import view.logged_in.tabs.SearchViewModel;
import view.logged_in.tabs.SearchViewState;

public class AddFriendPresenter implements AddFriendOutputBoundary {
  private final SearchViewModel searchViewModel;
  private final FollowedFriendsViewModel followedFriendsViewModel;
  private final MyLibraryViewModel myLibraryViewModel;
  private ViewManagerModel viewManagerModel;


  public AddFriendPresenter(
      FollowedFriendsViewModel followedFriendsViewModel,
      SearchViewModel searchViewModel,
      MyLibraryViewModel myLibraryViewModel, ViewManagerModel viewManagerModel) {
    this.followedFriendsViewModel = followedFriendsViewModel;
    this.searchViewModel = searchViewModel;
    this.myLibraryViewModel = myLibraryViewModel;
    this.viewManagerModel = viewManagerModel;
  }
  public void prepareSuccessView(AddFriendOutputData addFriendOutputData){
    SearchViewState searchViewState = searchViewModel.state;
    searchViewModel.firePropertyChanged();

    FollowedFriendsViewState followedFriendsViewState = followedFriendsViewModel.state;
    followedFriendsViewState.friendUsernames.add(addFriendOutputData.username);
    followedFriendsViewModel.firePropertyChanged();

    MyLibraryViewState myLibraryViewState = myLibraryViewModel.state;
    myLibraryViewState.personalPlaylists = addFriendOutputData.userPlaylists;
    myLibraryViewModel.firePropertyChanged();
  }


  public void prepareFailView(){
    SearchViewState searchViewState = searchViewModel.state;
    searchViewModel.firePropertyChanged();
  }
}

package services.remove_friend;

import view.ViewManagerModel;
import view.logged_in.tabs.FollowedFriendsViewModel;
import view.logged_in.tabs.FollowedFriendsViewState;
import view.logged_in.tabs.MyLibraryViewModel;
import view.logged_in.tabs.MyLibraryViewState;

public class RemoveFriendPresenter implements RemoveFriendOutputBoundary {

  private final FollowedFriendsViewModel followedFriendsViewModel;
  private final MyLibraryViewModel myLibraryViewModel;
  private final ViewManagerModel viewManagerModel;

  public RemoveFriendPresenter(FollowedFriendsViewModel followedFriendsViewModel,
      MyLibraryViewModel myLibraryViewModel, ViewManagerModel viewManagerModel) {
    this.followedFriendsViewModel = followedFriendsViewModel;
    this.myLibraryViewModel = myLibraryViewModel;
    this.viewManagerModel = viewManagerModel;
  }

  @Override
  public void prepareSuccessView(RemoveFriendOutputData removeFriendsOutput) {
    FollowedFriendsViewState followedFriendsViewState = followedFriendsViewModel.state;
    followedFriendsViewState.friendUsernames = removeFriendsOutput.userFriends;
    followedFriendsViewModel.firePropertyChanged();

    MyLibraryViewState myLibraryViewState = myLibraryViewModel.state;
    myLibraryViewState.personalPlaylists = removeFriendsOutput.userPlaylists;
    followedFriendsViewModel.firePropertyChanged();
  }


  @Override
  public void prepareFailView() {
    FollowedFriendsViewState followedFriendsViewState = followedFriendsViewModel.state;
    followedFriendsViewModel.firePropertyChanged();

  }
}

package services.add_friend;

import view.logged_in.tabs.FollowedFriendsViewModel;
import view.logged_in.tabs.FollowedFriendsViewState;
import view.logged_in.tabs.MyLibraryViewModel;
import view.logged_in.tabs.MyLibraryViewState;

public class AddFriendPresenter implements AddFriendOutputBoundary {

  private final FollowedFriendsViewModel followedFriendsViewModel;
  private final MyLibraryViewModel myLibraryViewModel;


  public AddFriendPresenter(
      FollowedFriendsViewModel followedFriendsViewModel,
      MyLibraryViewModel myLibraryViewModel) {
    this.followedFriendsViewModel = followedFriendsViewModel;
    this.myLibraryViewModel = myLibraryViewModel;
  }

  public void prepareSuccessView(AddFriendOutputData addFriendOutputData) {
    FollowedFriendsViewState followedFriendsViewState = followedFriendsViewModel.state;
    followedFriendsViewState.friendUsernames.add(addFriendOutputData.username);
    followedFriendsViewModel.firePropertyChanged();

    MyLibraryViewState myLibraryViewState = myLibraryViewModel.state;
    myLibraryViewState.personalPlaylists = addFriendOutputData.userPlaylists;
    myLibraryViewModel.firePropertyChanged();
  }


  public void prepareFailView() {
    // Do nothing, stay in the search view
  }
}

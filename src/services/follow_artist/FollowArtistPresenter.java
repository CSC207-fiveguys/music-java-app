package services.follow_artist;

import view.logged_in.tabs.FollowedArtistsViewModel;
import view.logged_in.tabs.FollowedArtistsViewState;
import view.logged_in.tabs.MyLibraryViewModel;
import view.logged_in.tabs.MyLibraryViewState;

public class FollowArtistPresenter implements FollowArtistOutputBoundary {

  private final FollowedArtistsViewModel followedArtistsViewModel;
  private final MyLibraryViewModel myLibraryViewModel;

  public FollowArtistPresenter(
      FollowedArtistsViewModel followedFriendsViewModel, MyLibraryViewModel myLibraryViewModel) {
    this.followedArtistsViewModel = followedFriendsViewModel;
    this.myLibraryViewModel = myLibraryViewModel;
  }

  @Override
  public void prepareSuccessView(FollowArtistOutputData followArtistOutputData) {
    FollowedArtistsViewState followedArtistsViewState = followedArtistsViewModel.state;
    followedArtistsViewState.artists = followArtistOutputData.artists;
    followedArtistsViewModel.firePropertyChanged();

    MyLibraryViewState myLibraryViewState = myLibraryViewModel.state;
    myLibraryViewState.personalPlaylists = followArtistOutputData.playlists;
    myLibraryViewModel.firePropertyChanged();
  }
}

package services.follow_artist;

import view.ViewManagerModel;
import view.logged_in.tabs.FollowedArtistsViewModel;
import view.logged_in.tabs.FollowedArtistsViewState;
import view.logged_in.tabs.MyLibraryViewModel;
import view.logged_in.tabs.SearchViewModel;
import view.logged_in.tabs.SearchViewState;

public class FollowArtistPresenter implements FollowArtistOutputBoundary {

  private final FollowedArtistsViewModel followedFriendsViewModel;

  public FollowArtistPresenter(
      FollowedArtistsViewModel followedFriendsViewModel) {
    this.followedFriendsViewModel = followedFriendsViewModel;
  }

  @Override
  public void prepareSuccessView(FollowArtistOutputData followArtistOutputData) {
    FollowedArtistsViewState followedArtistsViewState = followedFriendsViewModel.state;
    followedArtistsViewState.artists = followArtistOutputData.artists;
    followedFriendsViewModel.firePropertyChanged();
  }
}

package services.unfollow_artist;

import view.logged_in.tabs.FollowedArtistsViewModel;
import view.logged_in.tabs.FollowedArtistsViewState;

public class UnfollowArtistPresenter implements UnfollowArtistOutputBoundary {

  private final FollowedArtistsViewModel followedArtistsViewModel;

  public UnfollowArtistPresenter(FollowedArtistsViewModel followedFriendsViewModel) {
    this.followedArtistsViewModel = followedFriendsViewModel;
  }

  @Override
  public void prepareSuccessView(UnfollowArtistOutputData followArtistOutputData) {
    FollowedArtistsViewState followedArtistsViewState = followedArtistsViewModel.state;
    followedArtistsViewState.artists = followArtistOutputData.artists;
    followedArtistsViewModel.firePropertyChanged();

  }
}

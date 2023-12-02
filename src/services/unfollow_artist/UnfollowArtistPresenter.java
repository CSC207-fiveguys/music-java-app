package services.unfollow_artist;

import view.logged_in.tabs.FollowedArtistsViewModel;
import view.logged_in.tabs.FollowedArtistsViewState;

public class UnfollowArtistPresenter implements UnfollowArtistOutputBoundary {

  private final FollowedArtistsViewModel followedFriendsViewModel;

  public UnfollowArtistPresenter(FollowedArtistsViewModel followedFriendsViewModel) {
    this.followedFriendsViewModel = followedFriendsViewModel;
  }

  @Override
  public void prepareSuccessView(UnfollowArtistOutputData followArtistOutputData) {
    FollowedArtistsViewState followedArtistsViewState = followedFriendsViewModel.state;
    followedArtistsViewState.artists = followArtistOutputData.artists;
    followedFriendsViewModel.firePropertyChanged();

  }
}

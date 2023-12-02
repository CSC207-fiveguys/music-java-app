package services.follow_artist;

import entities.Artist;
import java.util.ArrayList;
import java.util.Map;
import javax.lang.model.type.ArrayType;
import view.ViewManagerModel;
import view.logged_in.tabs.FollowedArtistsViewModel;
import view.logged_in.tabs.FollowedArtistsViewState;
import view.logged_in.tabs.MyLibraryViewModel;
import view.logged_in.tabs.SearchViewModel;
import view.logged_in.tabs.SearchViewState;

public class FollowArtistPresenter implements FollowArtistOutputBoundary {
  private final SearchViewModel searchViewModel;
  private final FollowedArtistsViewModel followedFriendsViewModel;
  private final MyLibraryViewModel myLibraryViewModel;
  private ViewManagerModel viewManagerModel;

  public FollowArtistPresenter(
      SearchViewModel searchViewModel,
      FollowedArtistsViewModel followedFriendsViewModel,
      MyLibraryViewModel myLibraryViewModel,
      ViewManagerModel viewManagerModel) {
    this.searchViewModel = searchViewModel;
    this.followedFriendsViewModel = followedFriendsViewModel;
    this.myLibraryViewModel = myLibraryViewModel;
    this.viewManagerModel = viewManagerModel;
  }

  @Override
  public void prepareSuccessView(FollowArtistOutputData followArtistOutputData) {
    SearchViewState searchViewState = searchViewModel.state;
    searchViewModel.firePropertyChanged();

    FollowedArtistsViewState followedArtistsViewState = followedFriendsViewModel.state;
    followedArtistsViewState.artists = followArtistOutputData.artists;
    followedFriendsViewModel.firePropertyChanged();
  }
}

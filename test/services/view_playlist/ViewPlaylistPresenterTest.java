package services.view_playlist;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import services.unfollow_artist.UnfollowArtistOutputData;
import services.unfollow_artist.UnfollowArtistPresenter;
import view.ViewManagerModel;
import view.logged_in.PlaylistViewModel;
import view.logged_in.PlaylistViewState;
import view.logged_in.tabs.FollowedArtistsViewModel;
import view.logged_in.tabs.FollowedArtistsViewState;

class ViewPlaylistPresenterTest {

    @Test
    void prepareSuccessView() {
        PlaylistViewState playlistViewState = new PlaylistViewState();
        PlaylistViewModel playlistViewModel = new PlaylistViewModel("playlist view", playlistViewState);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        ViewPlaylistPresenter presenter = new ViewPlaylistPresenter(playlistViewModel, viewManagerModel);
        presenter.prepareSuccessView(new ViewPlaylistOutputData("playlistName", false, new ArrayList<>()));
        assertEquals(viewManagerModel.activeView, playlistViewModel.viewName);
    }
}
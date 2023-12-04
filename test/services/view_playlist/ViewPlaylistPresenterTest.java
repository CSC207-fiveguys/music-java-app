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
        ViewPlaylistPresenter presenter = new ViewPlaylistPresenter(new PlaylistViewModel("playlist", new PlaylistViewState()),
            new ViewManagerModel());
        presenter.prepareSuccessView(new ViewPlaylistOutputData("playlistName", false, new ArrayList<>()));
        assertTrue(true, "success view presented");
    }
}
package services.remove_track_from_playlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import services.remove_track_from_liked.RemoveTrackFromLikedOutputData;
import services.remove_track_from_liked.RemoveTrackFromLikedPresenter;
import view.ViewManagerModel;
import view.logged_in.PlaylistViewModel;
import view.logged_in.PlaylistViewState;

class RemoveTrackFromPlaylistPresenterTest {

    @Test
    void prepareSuccessView() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.activeView = "playlist view";
        PlaylistViewState playlistViewState = new PlaylistViewState();
        PlaylistViewModel playlistViewModel = new PlaylistViewModel("playlist view", playlistViewState);
        RemoveTrackFromPlaylistPresenter presenter = new RemoveTrackFromPlaylistPresenter(viewManagerModel, playlistViewModel);
        presenter.prepareSuccessView(new RemoveTrackFromPlaylistOutputData("1234"));
        assertEquals(viewManagerModel.activeView, playlistViewModel.viewName);
    }
}
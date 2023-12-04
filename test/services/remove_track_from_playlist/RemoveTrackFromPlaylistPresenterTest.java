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
        RemoveTrackFromPlaylistPresenter presenter = new RemoveTrackFromPlaylistPresenter(new ViewManagerModel(),
            new PlaylistViewModel("playlist", new PlaylistViewState()));
        presenter.prepareSuccessView(new RemoveTrackFromPlaylistOutputData("1234"));
        assertTrue(true, "success view presented");
    }
}
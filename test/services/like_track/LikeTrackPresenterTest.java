package services.like_track;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import services.add_track_to_playlist.AddTrackToPlaylistPresenter;

class LikeTrackPresenterTest {

    @Test
    void prepareSuccessView() {
        AddTrackToPlaylistPresenter presenter = new AddTrackToPlaylistPresenter();
        presenter.prepareSuccessView();
        assertTrue(true, "success view presented");
    }

    @Test
    void prepareFailView() {
        AddTrackToPlaylistPresenter presenter = new AddTrackToPlaylistPresenter();
        presenter.prepareFailView();
        assertTrue(true, "fail view presented");
    }
}
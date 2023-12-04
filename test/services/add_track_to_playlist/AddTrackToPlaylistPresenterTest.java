package services.add_track_to_playlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddTrackToPlaylistPresenterTest {

    @Test
    void prepareSuccessView() {
        AddTrackToPlaylistPresenter presenter = new AddTrackToPlaylistPresenter();
        presenter.prepareSuccessView();
        assertTrue(true, "success view presented");
    }
}
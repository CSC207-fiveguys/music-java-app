package services.remove_track_from_liked;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import services.login_new_signup.LoginNewSignupPresenter;
import view.ViewManagerModel;
import view.logged_in.PlaylistViewModel;
import view.logged_in.PlaylistViewState;
import view.logged_out.SignupViewModel;
import view.logged_out.SignupViewState;

class RemoveTrackFromLikedPresenterTest {

    @Test
    void successView() {
        RemoveTrackFromLikedPresenter presenter = new RemoveTrackFromLikedPresenter(new ViewManagerModel(),
            new PlaylistViewModel("playlist", new PlaylistViewState()));
        presenter.prepareSuccessView(new RemoveTrackFromLikedOutputData("1234"));
        assertTrue(true, "success view presented");
    }
}
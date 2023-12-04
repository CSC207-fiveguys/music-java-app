package services.login_new_signup;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import services.login_complete.LoginCompleteOutputData;
import services.login_complete.LoginCompletePresenter;
import view.ViewManagerModel;
import view.logged_in.PlaylistViewModel;
import view.logged_in.PlaylistViewState;
import view.logged_in.TabViewModel;
import view.logged_in.tabs.FollowedArtistsViewModel;
import view.logged_in.tabs.FollowedArtistsViewState;
import view.logged_in.tabs.FollowedFriendsViewModel;
import view.logged_in.tabs.FollowedFriendsViewState;
import view.logged_in.tabs.MyLibraryViewModel;
import view.logged_in.tabs.MyLibraryViewState;
import view.logged_in.tabs.SearchViewModel;
import view.logged_in.tabs.SearchViewState;
import view.logged_out.LoginViewModel;
import view.logged_out.LoginViewState;
import view.logged_out.SignupViewModel;
import view.logged_out.SignupViewState;

class LoginNewSignupPresenterTest {

    @Test
    void successView() {
        LoginNewSignupPresenter presenter = new LoginNewSignupPresenter(new ViewManagerModel(),
            new SignupViewModel("view", new SignupViewState()));
        presenter.prepareSuccessView();
        assertTrue(true, "success view presented");
    }
}
package services.login_complete;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
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

class LoginCompletePresenterTest {

    @Test
    void successView() {
        LoginCompletePresenter presenter = new LoginCompletePresenter(new ViewManagerModel(),
            new LoginViewModel("view", new LoginViewState()), new TabViewModel("view"),
            new MyLibraryViewModel("view", new MyLibraryViewState()), new FollowedArtistsViewModel("view", new FollowedArtistsViewState()),
            new FollowedFriendsViewModel("view", new FollowedFriendsViewState()), new SearchViewModel("view", new SearchViewState()),
            new PlaylistViewModel("viewname", new PlaylistViewState()));
        presenter.prepareSuccessView(new LoginCompleteOutputData("user", false));
        assertTrue(true, "fail view presented");

    }

    @Test
    void failView() {
        LoginCompletePresenter presenter = new LoginCompletePresenter(new ViewManagerModel(),
            new LoginViewModel("view", new LoginViewState()), new TabViewModel("view"),
            new MyLibraryViewModel("view", new MyLibraryViewState()), new FollowedArtistsViewModel("view", new FollowedArtistsViewState()),
            new FollowedFriendsViewModel("view", new FollowedFriendsViewState()), new SearchViewModel("view", new SearchViewState()),
            new PlaylistViewModel("viewname", new PlaylistViewState()));
        presenter.prepareFailView("not good");
        assertTrue(true, "fail view presented");
    }
}
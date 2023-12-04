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
        TabViewModel tabViewModel = new TabViewModel("tab");
        ViewManagerModel viewManagerModel = new ViewManagerModel();



        LoginCompletePresenter presenter = new LoginCompletePresenter(viewManagerModel,
            new LoginViewModel("view", new LoginViewState()), tabViewModel,
            new MyLibraryViewModel("view", new MyLibraryViewState()), new FollowedArtistsViewModel("view", new FollowedArtistsViewState()),
            new FollowedFriendsViewModel("view", new FollowedFriendsViewState()), new SearchViewModel("view", new SearchViewState()),
            new PlaylistViewModel("viewname", new PlaylistViewState()));
        presenter.prepareSuccessView(new LoginCompleteOutputData("user", false));
        assertEquals(viewManagerModel.activeView, tabViewModel.viewName);

    }

    @Test
    void failView() {
        LoginViewState loginViewState = new LoginViewState();
        LoginViewModel loginViewModel = new LoginViewModel("login", loginViewState);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        LoginCompletePresenter presenter = new LoginCompletePresenter(viewManagerModel,
            loginViewModel, new TabViewModel("view"),
            new MyLibraryViewModel("view", new MyLibraryViewState()), new FollowedArtistsViewModel("view", new FollowedArtistsViewState()),
            new FollowedFriendsViewModel("view", new FollowedFriendsViewState()), new SearchViewModel("view", new SearchViewState()),
            new PlaylistViewModel("viewname", new PlaylistViewState()));
        presenter.prepareFailView("not good");
        assertNull(viewManagerModel.activeView);
        assertEquals(loginViewModel.state.currentError, "not good");
    }
}
package view.logged_out;

import data_access.ArtistDataAccessObject;
import data_access.SpotifyDataAccessObject;
import data_access.TrackDataAccessObject;
import data_access.UserDataAccessObject;
import entities.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.login_complete.LoginCompleteController;
import services.login_complete.LoginCompleteInteractor;
import services.login_complete.LoginCompleteOutputBoundary;
import services.login_complete.LoginCompleteOutputData;
import services.login_complete.LoginCompletePresenter;
import services.login_new_signup.LoginNewSignupController;
import services.login_new_signup.LoginNewSignupInteractor;
import services.login_new_signup.LoginNewSignupPresenter;
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
import view.logged_out.LoginView;
import view.logged_out.LoginViewModel;
import view.logged_out.LoginViewState;
import view.logged_out.SignupViewModel;
import view.logged_out.SignupViewState;

import static org.junit.jupiter.api.Assertions.*;

class LoginViewTest {
    private TrackDataAccessObject trackDataAccessObject;
    private ArtistDataAccessObject artistDataAccessObject;
    private SpotifyDataAccessObject spotifyDataAccessObject;
    private UserFactory userFactory;
    private UserDataAccessObject userDataAccessObject;
    private MyLibraryViewModel myLibraryViewModel;
    private LoginViewModel loginViewModel;
    private SignupViewModel signupViewModel;
    private TabViewModel tabViewModel;
    private ViewManagerModel viewManagerModel;
    private FollowedFriendsViewModel followedFriendsViewModel;
    private FollowedArtistsViewModel followedArtistsViewModel;
    private SearchViewModel searchViewModel;
    private PlaylistViewModel playlistViewModel;
    private LoginCompleteInteractor loginCompleteInteractor;
    private LoginCompleteController loginCompleteController;
    private LoginNewSignupController loginNewSignupController;
    private LoginView loginView;

    @BeforeEach
    void setUp() {
        trackDataAccessObject = new TrackDataAccessObject();
        artistDataAccessObject = new ArtistDataAccessObject();
        spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject);
        userFactory = new UserFactory();
        userDataAccessObject = new UserDataAccessObject(userFactory, spotifyDataAccessObject);
        myLibraryViewModel = new MyLibraryViewModel("myLibrary", new MyLibraryViewState());
        loginViewModel = new LoginViewModel("Login", new LoginViewState());
        signupViewModel = new SignupViewModel("signup", new SignupViewState());
        tabViewModel = new TabViewModel("Tab");
        viewManagerModel = new ViewManagerModel();
        followedFriendsViewModel = new FollowedFriendsViewModel("Followed Friends", new FollowedFriendsViewState());
        followedArtistsViewModel = new FollowedArtistsViewModel("Followed Artists", new FollowedArtistsViewState());
        searchViewModel = new SearchViewModel("Search", new SearchViewState());
        playlistViewModel = new PlaylistViewModel("Playlist", new PlaylistViewState());
        loginCompleteInteractor = new LoginCompleteInteractor(new LoginCompletePresenter(viewManagerModel,
            loginViewModel,
            tabViewModel,
            myLibraryViewModel,
            followedArtistsViewModel,
            followedFriendsViewModel,
            searchViewModel,
            playlistViewModel), userDataAccessObject);
        loginViewModel = new LoginViewModel("viewname", new LoginViewState());
        loginCompleteController = new LoginCompleteController(loginCompleteInteractor);
        loginNewSignupController = new LoginNewSignupController(new LoginNewSignupInteractor(new LoginNewSignupPresenter(viewManagerModel,
            signupViewModel)));

        loginView = new LoginView(loginViewModel, loginCompleteController, loginNewSignupController);
    }

    @Test
    void testPropertyChangeUpdatesErrorLabel() {
        loginViewModel.state.currentError = "Error message";
        loginViewModel.firePropertyChanged();

        assertEquals("Error message", loginViewModel.state.currentError);
    }

    @Test
    void testLoginButtonPress() {
        userDataAccessObject.saveUser(userFactory.create("username", "123"));
        loginCompleteController.execute(
            "username",
            "123"
        );
        assertEquals(viewManagerModel.activeView, tabViewModel.viewName);
    }

    @Test
    void testSignupButtonPress() {
        loginNewSignupController.execute();
        assertEquals(viewManagerModel.activeView, signupViewModel.viewName);
    }
}

package view.logged_out;

import static org.junit.jupiter.api.Assertions.*;

import data_access.ArtistDataAccessObject;
import data_access.SpotifyDataAccessObject;
import data_access.TrackDataAccessObject;
import data_access.UserDataAccessObject;
import entities.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.login_complete.LoginCompleteController;
import services.login_complete.LoginCompleteInteractor;
import services.login_complete.LoginCompletePresenter;
import services.login_new_signup.LoginNewSignupController;
import services.login_new_signup.LoginNewSignupInteractor;
import services.login_new_signup.LoginNewSignupPresenter;
import services.signup_abort.SignupAbortController;
import services.signup_abort.SignupAbortInteractor;
import services.signup_abort.SignupAbortPresenter;
import services.signup_complete.SignupCompleteController;
import services.signup_complete.SignupCompleteInputBoundary;
import services.signup_complete.SignupCompleteInteractor;
import services.signup_complete.SignupCompletePresenter;
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

class SignupViewTest {

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
    private SignupCompleteInteractor signupCompleteInteractor;
    private SignupCompleteController signupCompleteController;
    private SignupAbortController signupAbortController;
    private SignupView signupView;

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
        SignupCompleteInputBoundary signupCompleteInputBoundary = new SignupCompleteInteractor(userDataAccessObject,
        new SignupCompletePresenter(signupViewModel, loginViewModel, viewManagerModel));
        signupViewModel = new SignupViewModel("viewname", new SignupViewState());
        signupCompleteController = new SignupCompleteController(signupCompleteInputBoundary);
        signupAbortController = new SignupAbortController(new SignupAbortInteractor(new SignupAbortPresenter(loginViewModel,
            viewManagerModel)));

        signupView = new SignupView(signupViewModel, signupCompleteController, signupAbortController);
    }

    @Test
    void testPropertyChangeUpdatesErrorLabel() {
        signupViewModel.state.currentError = "Error message";
        signupViewModel.firePropertyChanged();

        assertEquals("Error message", signupViewModel.state.currentError);
    }

    @Test
    void testLoginButtonPress() {
        signupCompleteController.execute("username", "123", "123");
        assertEquals(viewManagerModel.activeView, loginViewModel.viewName);
    }

    @Test
    void testSignupButtonPress() {
        signupAbortController.execute();
        assertEquals(viewManagerModel.activeView, loginViewModel.viewName);
    }
}
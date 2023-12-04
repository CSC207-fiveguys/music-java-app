package view.logged_in;

import static org.junit.jupiter.api.Assertions.*;

import data_access.ArtistDataAccessObject;
import data_access.SpotifyDataAccessObject;
import data_access.TrackDataAccessObject;
import data_access.UserDataAccessObject;
import entities.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.back_to_tab_view.BackToTabViewController;
import services.back_to_tab_view.BackToTabViewInteractor;
import services.back_to_tab_view.BackToTabViewPresenter;
import services.login_complete.LoginCompleteController;
import services.login_complete.LoginCompleteInteractor;
import services.login_complete.LoginCompletePresenter;
import services.login_new_signup.LoginNewSignupController;
import services.login_new_signup.LoginNewSignupInteractor;
import services.login_new_signup.LoginNewSignupPresenter;
import services.remove_track_from_liked.RemoveTrackFromLikedController;
import services.remove_track_from_liked.RemoveTrackFromLikedInteractor;
import services.remove_track_from_liked.RemoveTrackFromLikedPresenter;
import services.remove_track_from_playlist.RemoveTrackFromPlaylistController;
import services.remove_track_from_playlist.RemoveTrackFromPlaylistInteractor;
import services.remove_track_from_playlist.RemoveTrackFromPlaylistPresenter;
import view.ViewManagerModel;
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

class PlaylistViewTest {

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
    private BackToTabViewController backToTabViewController;
    private RemoveTrackFromLikedController removeTrackFromLikedController;
    private RemoveTrackFromPlaylistController removeTrackFromPlaylistController;
    private PlaylistView playlistView;

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
        backToTabViewController = new BackToTabViewController(new BackToTabViewInteractor(new BackToTabViewPresenter(tabViewModel,
            viewManagerModel)));
        removeTrackFromLikedController = new RemoveTrackFromLikedController(new RemoveTrackFromLikedInteractor(userDataAccessObject, new RemoveTrackFromLikedPresenter(viewManagerModel,
            playlistViewModel)));
        removeTrackFromPlaylistController = new RemoveTrackFromPlaylistController(new RemoveTrackFromPlaylistInteractor(userDataAccessObject, new RemoveTrackFromPlaylistPresenter(viewManagerModel,
            playlistViewModel)));
        playlistView = new PlaylistView(playlistViewModel, backToTabViewController, removeTrackFromLikedController, removeTrackFromPlaylistController);
    }

    @Test
    void testBackButtonAction() {
        backToTabViewController.execute();
        assertEquals(viewManagerModel.activeView, tabViewModel.viewName);
    }

    @Test
    void testPropertyChangeUpdatesView() {
        playlistViewModel.state.username = "user";
        playlistViewModel.firePropertyChanged();

        assertEquals("user", playlistViewModel.state.username);
    }

}
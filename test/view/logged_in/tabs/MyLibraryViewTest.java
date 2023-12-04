package view.logged_in.tabs;

import static org.junit.jupiter.api.Assertions.*;

import data_access.ArtistDataAccessObject;
import data_access.SpotifyDataAccessObject;
import data_access.TrackDataAccessObject;
import data_access.UserDataAccessObject;
import entities.User;
import entities.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.create_new_playlist.CreateNewPlaylistController;
import services.create_new_playlist.CreateNewPlaylistInteractor;
import services.create_new_playlist.CreateNewPlaylistPresenter;
import services.remove_playlist.RemovePlaylistController;
import services.remove_playlist.RemovePlaylistInteractor;
import services.remove_playlist.RemovePlaylistPresenter;
import services.unfollow_artist.UnfollowArtistController;
import services.unfollow_artist.UnfollowArtistInteractor;
import services.unfollow_artist.UnfollowArtistPresenter;
import services.view_playlist.ViewPlaylistController;
import services.view_playlist.ViewPlaylistInteractor;
import services.view_playlist.ViewPlaylistPresenter;
import view.ViewManagerModel;
import view.logged_in.PlaylistViewModel;
import view.logged_in.PlaylistViewState;
import view.logged_in.TabViewModel;
import view.logged_out.LoginViewModel;
import view.logged_out.LoginViewState;
import view.logged_out.SignupViewModel;
import view.logged_out.SignupViewState;

class MyLibraryViewTest {

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
    private CreateNewPlaylistController createNewPlaylistController;
    private ViewPlaylistController viewPlaylistController;
    private RemovePlaylistController removePlaylistController;
    private MyLibraryView myLibraryView;

    private PlaylistViewModel playlistViewModel;
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
        viewPlaylistController = new ViewPlaylistController(new ViewPlaylistInteractor(userDataAccessObject,
            new ViewPlaylistPresenter(playlistViewModel,
            viewManagerModel), trackDataAccessObject));
        createNewPlaylistController = new CreateNewPlaylistController(new CreateNewPlaylistInteractor(userDataAccessObject, new CreateNewPlaylistPresenter(myLibraryViewModel)));
        removePlaylistController = new RemovePlaylistController(new RemovePlaylistInteractor(userDataAccessObject, new RemovePlaylistPresenter(myLibraryViewModel)));
        myLibraryView = new MyLibraryView(myLibraryViewModel, createNewPlaylistController, viewPlaylistController,
            removePlaylistController);
    }

    @Test
    void newPlaylistButtonPressed() {
        User user = userFactory.create("user", "123");
        userDataAccessObject.saveUser(user);
        createNewPlaylistController.execute("playlistName", "user");
        assertFalse(user.getPlaylists().isEmpty());
    }

    @Test
    void propertyChange() {
        myLibraryViewModel.state.username = "user";
        myLibraryViewModel.firePropertyChanged();

        assertEquals("user", myLibraryViewModel.state.username);
    }
}
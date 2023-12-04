package view.logged_in.tabs;

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
import services.remove_track_from_liked.RemoveTrackFromLikedController;
import services.remove_track_from_liked.RemoveTrackFromLikedInteractor;
import services.remove_track_from_liked.RemoveTrackFromLikedPresenter;
import services.remove_track_from_playlist.RemoveTrackFromPlaylistController;
import services.remove_track_from_playlist.RemoveTrackFromPlaylistInteractor;
import services.remove_track_from_playlist.RemoveTrackFromPlaylistPresenter;
import services.unfollow_artist.UnfollowArtistController;
import services.unfollow_artist.UnfollowArtistInteractor;
import services.unfollow_artist.UnfollowArtistPresenter;
import view.ViewManagerModel;
import view.logged_in.PlaylistView;
import view.logged_in.PlaylistViewModel;
import view.logged_in.PlaylistViewState;
import view.logged_in.TabViewModel;
import view.logged_out.LoginViewModel;
import view.logged_out.LoginViewState;
import view.logged_out.SignupViewModel;
import view.logged_out.SignupViewState;

class FollowedArtistsViewTest {

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
    private UnfollowArtistController unfollowArtistController;
    private FollowedArtistsView followedArtistsView;
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
        unfollowArtistController = new UnfollowArtistController(new UnfollowArtistInteractor(artistDataAccessObject, userDataAccessObject, new UnfollowArtistPresenter(followedArtistsViewModel)));
        followedArtistsView = new FollowedArtistsView(followedArtistsViewModel, unfollowArtistController);
    }

    @Test
    void propertyChange() {
        followedArtistsViewModel.state.username = "user";
        followedArtistsViewModel.firePropertyChanged();

        assertEquals("user", followedArtistsViewModel.state.username);
    }
}
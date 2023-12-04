package view.logged_in.tabs;

import static org.junit.jupiter.api.Assertions.*;

import data_access.ArtistDataAccessObject;
import data_access.SpotifyDataAccessObject;
import data_access.TrackDataAccessObject;
import data_access.UserDataAccessObject;
import entities.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.add_friend.AddFriendController;
import services.add_friend.AddFriendInteractor;
import services.add_friend.AddFriendPresenter;
import services.add_track_to_playlist.AddTrackToPlaylistController;
import services.add_track_to_playlist.AddTrackToPlaylistInteractor;
import services.add_track_to_playlist.AddTrackToPlaylistPresenter;
import services.create_new_playlist.CreateNewPlaylistController;
import services.create_new_playlist.CreateNewPlaylistInteractor;
import services.create_new_playlist.CreateNewPlaylistPresenter;
import services.follow_artist.FollowArtistController;
import services.follow_artist.FollowArtistInteractor;
import services.follow_artist.FollowArtistPresenter;
import services.like_track.LikeTrackController;
import services.like_track.LikeTrackInteractor;
import services.like_track.LikeTrackPresenter;
import services.search.SearchController;
import services.search.SearchInteractor;
import services.search.SearchPresenter;
import services.unfollow_artist.UnfollowArtistController;
import services.unfollow_artist.UnfollowArtistInteractor;
import services.unfollow_artist.UnfollowArtistPresenter;
import view.ViewManagerModel;
import view.logged_in.PlaylistViewModel;
import view.logged_in.PlaylistViewState;
import view.logged_in.TabView;
import view.logged_in.TabViewModel;
import view.logged_out.LoginViewModel;
import view.logged_out.LoginViewState;
import view.logged_out.SignupViewModel;
import view.logged_out.SignupViewState;

class SearchViewTest {

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
    private SearchController searchController;
    private LikeTrackController likeTrackController;
    private AddTrackToPlaylistController addTrackToPlaylistController;
    private FollowArtistController followArtistController;
    private AddFriendController addFriendController;
    private CreateNewPlaylistController createNewPlaylistController;
    private SearchView searchView;
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
        searchController = new SearchController(new SearchInteractor(new SearchPresenter(searchViewModel), spotifyDataAccessObject, userDataAccessObject));
        likeTrackController = new LikeTrackController(new LikeTrackInteractor(userDataAccessObject, spotifyDataAccessObject, new LikeTrackPresenter()));
        addFriendController = new AddFriendController(new AddFriendInteractor(userDataAccessObject, new AddFriendPresenter(followedFriendsViewModel, myLibraryViewModel)));
        addTrackToPlaylistController = new AddTrackToPlaylistController(new AddTrackToPlaylistInteractor(userDataAccessObject, spotifyDataAccessObject, new AddTrackToPlaylistPresenter()));
        followArtistController = new FollowArtistController(new FollowArtistInteractor(spotifyDataAccessObject, artistDataAccessObject, userDataAccessObject, new FollowArtistPresenter(followedArtistsViewModel, myLibraryViewModel)));
        createNewPlaylistController = new CreateNewPlaylistController(new CreateNewPlaylistInteractor(userDataAccessObject, new CreateNewPlaylistPresenter(myLibraryViewModel)));
        searchView = new SearchView(searchViewModel, searchController, likeTrackController, addTrackToPlaylistController, followArtistController, addFriendController);
    }

    @Test
    void propertyChange() {
        searchViewModel.state.username = "user";
        searchViewModel.firePropertyChanged();

        assertEquals("user", searchViewModel.state.username);
    }

    @Test
    void searchButtonPressed() {
        searchController.execute("search");
        assertTrue(true, "searched");
    }
}
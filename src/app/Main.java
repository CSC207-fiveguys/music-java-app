package app;

import data_access.ArtistDataAccessObject;
import data_access.SpotifyDataAccessObject;
import data_access.TrackDataAccessObject;
import data_access.UserDataAccessObject;
import entities.Track;
import entities.UserFactory;
import services.back_to_tab_view.*;
import services.login_complete.*;
import services.login_new_signup.*;
import services.search.SearchController;
import services.search.SearchInputBoundary;
import services.search.SearchInteractor;
import services.search.SearchOutputBoundary;
import services.search.SearchPresenter;
import services.signup_abort.*;
import services.signup_complete.*;
import services.unfollow_artist.UnfollowArtistController;
import services.unfollow_artist.UnfollowArtistInputBoundary;
import services.unfollow_artist.UnfollowArtistInteractor;
import services.unfollow_artist.UnfollowArtistOutputBoundary;
import services.unfollow_artist.UnfollowArtistPresenter;
import view.ViewManager;
import view.ViewManagerModel;
import view.logged_in.*;
import view.logged_in.tabs.*;
import view.logged_out.*;

import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {

    public static void main(String[] args) {
        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel(cardLayout);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        ViewManager viewManager = new ViewManager(viewManagerModel, views, cardLayout);
        TabViewModel tabViewModel = new TabViewModel("tab view");
        JFrame frame = new JFrame("CSC207 5 GUYS SPOTIFY");

        // CREATE DAOs

        UserDataAccessObject userDataAccessObject = new UserDataAccessObject(new UserFactory());
        TrackDataAccessObject trackDataAccessObject = new TrackDataAccessObject();
        ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
        SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject);

        // CREATE VIEW MODELS (that have states)

        LoginViewState loginViewState = new LoginViewState();
        LoginViewModel loginViewModel = new LoginViewModel("log in view", loginViewState);

        SignupViewState signupViewState = new SignupViewState();
        SignupViewModel signupViewModel = new SignupViewModel("sign up view", signupViewState);

        MyLibraryViewState myLibraryViewState = new MyLibraryViewState();
        MyLibraryViewModel myLibraryViewModel = new MyLibraryViewModel("My Library", myLibraryViewState);

        FollowedArtistsViewState followedArtistsViewState = new FollowedArtistsViewState();
        FollowedArtistsViewModel followedArtistsViewModel = new FollowedArtistsViewModel("Followed Artists", followedArtistsViewState);

        FollowedFriendsViewState followedFriendsViewState = new FollowedFriendsViewState();
        FollowedFriendsViewModel followedFriendsViewModel = new FollowedFriendsViewModel("Followed Friends", followedFriendsViewState);

        SearchViewState searchViewState = new SearchViewState();
        SearchViewModel searchViewModel = new SearchViewModel("Search", searchViewState);

        PlaylistViewState playlistViewState = new PlaylistViewState();
        PlaylistViewModel playlistViewModel = new PlaylistViewModel("playlist view", playlistViewState);

        // CREATE SERVICES (controllers)

        LoginNewSignupOutputBoundary loginNewSignupPresenter = new LoginNewSignupPresenter(viewManagerModel, signupViewModel);
        LoginNewSignupInputBoundary loginNewSignupInteractor = new LoginNewSignupInteractor(loginNewSignupPresenter);
        LoginNewSignupController loginNewSignupController = new LoginNewSignupController(loginNewSignupInteractor);

        LoginCompleteOutputBoundary loginCompletePresenter = new LoginCompletePresenter(viewManagerModel, loginViewModel, tabViewModel, myLibraryViewModel, followedArtistsViewModel, followedFriendsViewModel, searchViewModel, playlistViewModel);
        LoginCompleteInputBoundary loginCompleteInteractor = new LoginCompleteInteractor(loginCompletePresenter, userDataAccessObject);
        LoginCompleteController loginCompleteController = new LoginCompleteController(loginCompleteInteractor);

        SignupAbortOutputBoundary abortSignupPresenter = new SignupAbortPresenter(loginViewModel, viewManagerModel);
        SignupAbortInputBoundary abortSignupInteractor = new SignupAbortInteractor(abortSignupPresenter);
        SignupAbortController signupAbortController = new SignupAbortController(abortSignupInteractor);

        SignupCompleteOutputBoundary signupCompletePresenter = new SignupCompletePresenter(signupViewModel, loginViewModel, viewManagerModel);
        SignupCompleteInputBoundary signupCompleteInteractor = new SignupCompleteInteractor(userDataAccessObject, signupCompletePresenter);
        SignupCompleteController signupCompleteController = new SignupCompleteController(signupCompleteInteractor);

        SearchOutputBoundary searchPresenter = new SearchPresenter(searchViewModel);
        SearchInputBoundary searchInteractor = new SearchInteractor(searchPresenter, spotifyDataAccessObject, userDataAccessObject);
        SearchController searchController = new SearchController(searchInteractor);

        BackToTabViewOutputBoundary backToTabViewPresenter = new BackToTabViewPresenter(tabViewModel, viewManagerModel);
        BackToTabViewInputBoundary backToTabViewInteractor = new BackToTabViewInteractor(backToTabViewPresenter);
        BackToTabViewController backToTabViewController = new BackToTabViewController(backToTabViewInteractor);

        UnfollowArtistOutputBoundary unfollowArtistPresenter = new UnfollowArtistPresenter(followedArtistsViewModel);
        UnfollowArtistInputBoundary unfollowArtistInteractor = new UnfollowArtistInteractor(artistDataAccessObject, userDataAccessObject, unfollowArtistPresenter);
        UnfollowArtistController unfollowArtistController = new UnfollowArtistController(unfollowArtistInteractor);

        // CREATE VIEWS

        LoginView loginView = new LoginView(
                loginViewModel,
                loginCompleteController,
                loginNewSignupController
        );
        views.add(loginView, loginViewModel.viewName);

        SignupView signupView = new SignupView(
                signupViewModel,
                signupCompleteController,
                signupAbortController
        );
        views.add(signupView, signupViewModel.viewName);

        TabView tabView = new TabView(
                tabViewModel,
                myLibraryViewModel,
                followedArtistsViewModel,
                followedFriendsViewModel,
                searchViewModel,
                null,
                null,
                null,
                null,
                unfollowArtistController,
                null,
                null,
                searchController,
                null,
                null
        );
        views.add(tabView, tabViewModel.viewName);

        PlaylistView playlistView = new PlaylistView(
                playlistViewModel,
                backToTabViewController,
                null,
                null
        );
        views.add(playlistView, playlistViewModel.viewName);
        playlistViewModel.firePropertyChanged();

        // RUN APP

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(views);
        frame.setPreferredSize(new Dimension(1360, 460));
        frame.pack();
        frame.setVisible(true);
    }
}
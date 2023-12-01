package app;

import data_access.TrackDataAccessObject;
import data_access.UserDataAccessObject;
import entities.UserFactory;
import services.back_to_tab_view.*;
import services.login_complete.*;
import services.login_new_signup.*;
import services.signup_abort.*;
import services.signup_complete.*;
import services.view_playlist.ViewPlaylistController;
import services.view_playlist.ViewPlaylistInputBoundary;
import services.view_playlist.ViewPlaylistInteractor;
import services.view_playlist.ViewPlaylistOutputBoundary;
import services.view_playlist.ViewPlaylistPresenter;
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

        BackToTabViewOutputBoundary backToTabViewPresenter = new BackToTabViewPresenter(tabViewModel, viewManagerModel);
        BackToTabViewInputBoundary backToTabViewInteractor = new BackToTabViewInteractor(backToTabViewPresenter);
        BackToTabViewController backToTabViewController = new BackToTabViewController(backToTabViewInteractor);

        ViewPlaylistOutputBoundary viewPlaylistPresenter = new ViewPlaylistPresenter(playlistViewModel,
            viewManagerModel);
        ViewPlaylistInputBoundary viewPlaylistInteractor = new ViewPlaylistInteractor(userDataAccessObject, viewPlaylistPresenter, trackDataAccessObject);
        ViewPlaylistController viewPlaylistController = new ViewPlaylistController(viewPlaylistInteractor);

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
                viewPlaylistController,
                null,
                null,
                null,
                null,
                null,
                null,
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
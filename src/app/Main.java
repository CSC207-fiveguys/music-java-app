package app;

import data_access.ArtistDataAccessObject;
import data_access.SpotifyDataAccessObject;
import data_access.TrackDataAccessObject;
import data_access.UserDataAccessObject;
import entities.UserFactory;
import services.add_track_to_playlist.*;
import services.like_track.*;
import services.add_friend.AddFriendController;
import services.add_friend.AddFriendInputBoundary;
import services.add_friend.AddFriendInteractor;
import services.add_friend.AddFriendOutputBoundary;
import services.add_friend.AddFriendPresenter;
import services.back_to_tab_view.*;
import services.follow_artist.FollowArtistController;
import services.follow_artist.FollowArtistInputBoundary;
import services.follow_artist.FollowArtistInteractor;
import services.follow_artist.FollowArtistOutputBoundary;
import services.follow_artist.FollowArtistPresenter;
import services.create_new_playlist.CreateNewPlaylistController;
import services.create_new_playlist.CreateNewPlaylistInputBoundary;
import services.create_new_playlist.CreateNewPlaylistInteractor;
import services.create_new_playlist.CreateNewPlaylistOutputBoundary;
import services.create_new_playlist.CreateNewPlaylistPresenter;
import services.login_complete.*;
import services.login_new_signup.*;
import services.remove_track_from_liked.*;
import services.remove_track_from_playlist.*;
import services.remove_friend.RemoveFriendController;
import services.remove_friend.RemoveFriendInputBoundary;
import services.remove_friend.RemoveFriendInteractor;
import services.remove_friend.RemoveFriendOutputBoundary;
import services.remove_friend.RemoveFriendPresenter;
import services.remove_playlist.RemovePlaylistController;
import services.remove_playlist.RemovePlaylistInputBoundary;
import services.remove_playlist.RemovePlaylistInteractor;
import services.remove_playlist.RemovePlaylistOutputBoundary;
import services.remove_playlist.RemovePlaylistPresenter;
import services.search.SearchAlgorithmContains;
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

        TrackDataAccessObject trackDataAccessObject = new TrackDataAccessObject();

        ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
        SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject);

        UserDataAccessObject userDataAccessObject = new UserDataAccessObject(new UserFactory(), spotifyDataAccessObject);


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

        RemoveFriendOutputBoundary removeFriendPresenter = new RemoveFriendPresenter(
            followedFriendsViewModel, myLibraryViewModel);
        RemoveFriendInputBoundary removeFriendInteractor = new RemoveFriendInteractor(userDataAccessObject, removeFriendPresenter);
        RemoveFriendController removeFriendController = new RemoveFriendController(removeFriendInteractor);

        AddFriendOutputBoundary addFriendPresenter = new AddFriendPresenter(followedFriendsViewModel,
            myLibraryViewModel);
        AddFriendInputBoundary addFriendInteractor = new AddFriendInteractor(userDataAccessObject, addFriendPresenter);
        AddFriendController addFriendController = new AddFriendController(addFriendInteractor);
      
        SearchOutputBoundary searchPresenter = new SearchPresenter(searchViewModel);
        SearchInputBoundary searchInteractor = new SearchInteractor(searchPresenter, spotifyDataAccessObject, userDataAccessObject);
        SearchController searchController = new SearchController(searchInteractor, new SearchAlgorithmContains());

        BackToTabViewOutputBoundary backToTabViewPresenter = new BackToTabViewPresenter(tabViewModel, viewManagerModel);
        BackToTabViewInputBoundary backToTabViewInteractor = new BackToTabViewInteractor(backToTabViewPresenter);
        BackToTabViewController backToTabViewController = new BackToTabViewController(backToTabViewInteractor);

        UnfollowArtistOutputBoundary unfollowArtistPresenter = new UnfollowArtistPresenter(followedArtistsViewModel);
        UnfollowArtistInputBoundary unfollowArtistInteractor = new UnfollowArtistInteractor(artistDataAccessObject, userDataAccessObject, unfollowArtistPresenter);
        UnfollowArtistController unfollowArtistController = new UnfollowArtistController(unfollowArtistInteractor);

        FollowArtistOutputBoundary followArtistPresenter = new FollowArtistPresenter(followedArtistsViewModel,
            myLibraryViewModel);
        FollowArtistInputBoundary followArtistInteractor = new FollowArtistInteractor(
            spotifyDataAccessObject, artistDataAccessObject, userDataAccessObject, followArtistPresenter);
        FollowArtistController followArtistController = new FollowArtistController(followArtistInteractor);

        CreateNewPlaylistOutputBoundary createNewPlaylistPresenter = new CreateNewPlaylistPresenter(myLibraryViewModel);
        CreateNewPlaylistInputBoundary createNewPlaylistInteractor = new CreateNewPlaylistInteractor(userDataAccessObject, createNewPlaylistPresenter);
        CreateNewPlaylistController createNewPlaylistController = new CreateNewPlaylistController(createNewPlaylistInteractor);

        RemovePlaylistOutputBoundary removePlaylistPresenter = new RemovePlaylistPresenter(myLibraryViewModel);
        RemovePlaylistInputBoundary removePlaylistInteractor = new RemovePlaylistInteractor(userDataAccessObject, removePlaylistPresenter);
        RemovePlaylistController removePlaylistController = new RemovePlaylistController(removePlaylistInteractor);

        ViewPlaylistOutputBoundary viewPlaylistPresenter = new ViewPlaylistPresenter(playlistViewModel,
            viewManagerModel);
        ViewPlaylistInputBoundary viewPlaylistInteractor = new ViewPlaylistInteractor(userDataAccessObject, viewPlaylistPresenter, trackDataAccessObject);
        ViewPlaylistController viewPlaylistController = new ViewPlaylistController(viewPlaylistInteractor);
        
        AddTrackToPlaylistOutputBoundary addTrackToPlaylistPresenter = new AddTrackToPlaylistPresenter();
        AddTrackToPlaylistInputBoundary addTrackToPlaylistInteractor = new AddTrackToPlaylistInteractor(userDataAccessObject, spotifyDataAccessObject, addTrackToPlaylistPresenter);
        AddTrackToPlaylistController addTrackToPlaylistController = new AddTrackToPlaylistController(addTrackToPlaylistInteractor);

        LikeTrackOutputBoundary likeTrackPresenter = new LikeTrackPresenter();
        LikeTrackInputBoundary likeTrackInteractor = new LikeTrackInteractor(userDataAccessObject, spotifyDataAccessObject, likeTrackPresenter);
        LikeTrackController likeTrackController = new LikeTrackController(likeTrackInteractor);

        RemoveTrackFromPlaylistOutputBoundary removeTrackFromPlaylistPresenter = new RemoveTrackFromPlaylistPresenter(viewManagerModel, playlistViewModel);
        RemoveTrackFromPlaylistInputBoundary removeTrackFromPlaylistInteractor = new RemoveTrackFromPlaylistInteractor(userDataAccessObject, removeTrackFromPlaylistPresenter);
        RemoveTrackFromPlaylistController removeTrackFromPlaylistController = new RemoveTrackFromPlaylistController(removeTrackFromPlaylistInteractor);

        RemoveTrackFromLikedOutputBoundary removeTrackFromLikedPresenter = new RemoveTrackFromLikedPresenter(viewManagerModel, playlistViewModel);
        RemoveTrackFromLikedInputBoundary removeTrackFromLikedInteractor = new RemoveTrackFromLikedInteractor(userDataAccessObject, removeTrackFromLikedPresenter);
        RemoveTrackFromLikedController removeTrackFromLikedController = new RemoveTrackFromLikedController(removeTrackFromLikedInteractor);


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
                createNewPlaylistController,
                viewPlaylistController,
                removePlaylistController,
                followArtistController,
                unfollowArtistController,
                addFriendController,
                removeFriendController,
                searchController,
                likeTrackController,
                addTrackToPlaylistController
        );

        views.add(tabView, tabViewModel.viewName);

        PlaylistView playlistView = new PlaylistView(
                playlistViewModel,
                backToTabViewController,
                removeTrackFromLikedController,
                removeTrackFromPlaylistController
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

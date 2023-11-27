package services.login_complete;

import view.ViewManagerModel;
import view.logged_in.PlaylistViewModel;
import view.logged_in.TabViewModel;
import view.logged_in.tabs.FollowedArtistsViewModel;
import view.logged_in.tabs.FollowedFriendsViewModel;
import view.logged_in.tabs.MyLibraryViewModel;
import view.logged_in.tabs.SearchViewModel;
import view.logged_out.LoginViewModel;

public class LoginCompletePresenter implements LoginCompleteOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final ViewManagerModel viewManagerModel;
    private final TabViewModel tabViewModel;
    private final MyLibraryViewModel myLibraryViewModel;
    private final FollowedArtistsViewModel followedArtistsViewModel;
    private final FollowedFriendsViewModel followedFriendsViewModel;
    private final SearchViewModel searchViewModel;
    private final PlaylistViewModel playlistViewModel;

    public LoginCompletePresenter(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            TabViewModel tabViewModel,
            MyLibraryViewModel myLibraryViewModel,
            FollowedArtistsViewModel followedArtistsViewModel,
            FollowedFriendsViewModel followedFriendsViewModel,
            SearchViewModel searchViewModel,
            PlaylistViewModel playlistViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loginViewModel = loginViewModel;
        this.tabViewModel = tabViewModel;
        this.myLibraryViewModel = myLibraryViewModel;
        this.followedArtistsViewModel = followedArtistsViewModel;
        this.followedFriendsViewModel = followedFriendsViewModel;
        this.searchViewModel = searchViewModel;
        this.playlistViewModel = playlistViewModel;
    }

    @Override
    public void prepareSuccessView(LoginCompleteOutputData response) {
        viewManagerModel.activeView = tabViewModel.viewName;
        viewManagerModel.firePropertyChanged();

        myLibraryViewModel.state.username = response.username;
        myLibraryViewModel.firePropertyChanged();
        followedArtistsViewModel.state.username = response.username;
        followedArtistsViewModel.firePropertyChanged();
        followedFriendsViewModel.state.username = response.username;
        followedFriendsViewModel.firePropertyChanged();
        searchViewModel.state.username = response.username;
        searchViewModel.firePropertyChanged();
        playlistViewModel.state.username = response.username;
        playlistViewModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String error) {
        loginViewModel.state.currentError = error;
        loginViewModel.firePropertyChanged();
    }
}

package services.add_friend;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import services.login_complete.LoginCompleteOutputData;
import services.login_complete.LoginCompletePresenter;
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
import view.logged_out.LoginViewModel;
import view.logged_out.LoginViewState;

class AddFriendPresenterTest {

    @Test
    void successView() {
        MyLibraryViewState myLibraryViewState = new MyLibraryViewState();
        MyLibraryViewModel myLibraryViewModel = new MyLibraryViewModel("my library", myLibraryViewState);
        FollowedFriendsViewState followedFriendsViewState = new FollowedFriendsViewState();
        FollowedFriendsViewModel followedFriendsViewModel = new FollowedFriendsViewModel("followed friends", followedFriendsViewState);
        AddFriendPresenter addFriendPresenter = new AddFriendPresenter(followedFriendsViewModel, myLibraryViewModel);
        addFriendPresenter.prepareSuccessView(new AddFriendOutputData("user", new ArrayList<>()));
        assertFalse(followedFriendsViewState.friendUsernames.isEmpty());

    }

    @Test
    void failView() {
        MyLibraryViewState myLibraryViewState = new MyLibraryViewState();
        MyLibraryViewModel myLibraryViewModel = new MyLibraryViewModel("my library", myLibraryViewState);
        FollowedFriendsViewState followedFriendsViewState = new FollowedFriendsViewState();
        FollowedFriendsViewModel followedFriendsViewModel = new FollowedFriendsViewModel("followed friends", followedFriendsViewState);
        AddFriendPresenter addFriendPresenter = new AddFriendPresenter(followedFriendsViewModel, myLibraryViewModel);
        addFriendPresenter.prepareFailView();
        assertTrue(followedFriendsViewModel.state.friendUsernames.isEmpty());
    }
}
package services.remove_friend;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import services.add_friend.AddFriendOutputData;
import services.add_friend.AddFriendPresenter;
import view.logged_in.tabs.FollowedFriendsViewModel;
import view.logged_in.tabs.FollowedFriendsViewState;
import view.logged_in.tabs.MyLibraryViewModel;
import view.logged_in.tabs.MyLibraryViewState;

class RemoveFriendPresenterTest {

    @Test
    void prepareSuccessView() {
        FollowedFriendsViewState followedFriendsViewState = new FollowedFriendsViewState();
        FollowedFriendsViewModel followedFriendsViewModel = new FollowedFriendsViewModel("followed friends", followedFriendsViewState);
        MyLibraryViewState myLibraryViewState = new MyLibraryViewState();
        MyLibraryViewModel myLibraryViewModel = new MyLibraryViewModel("my library", myLibraryViewState);
        RemoveFriendPresenter removeFriendPresenter = new RemoveFriendPresenter(followedFriendsViewModel, myLibraryViewModel);
        removeFriendPresenter.prepareSuccessView(new RemoveFriendOutputData(new ArrayList<>(), new ArrayList<>()));
        assertTrue(followedFriendsViewState.friendUsernames.isEmpty());
    }

    @Test
    void prepareFailView() {
        FollowedFriendsViewState followedFriendsViewState = new FollowedFriendsViewState();
        FollowedFriendsViewModel followedFriendsViewModel = new FollowedFriendsViewModel("followed friends", followedFriendsViewState);
        MyLibraryViewState myLibraryViewState = new MyLibraryViewState();
        MyLibraryViewModel myLibraryViewModel = new MyLibraryViewModel("my library", myLibraryViewState);
        RemoveFriendPresenter removeFriendPresenter = new RemoveFriendPresenter(followedFriendsViewModel, myLibraryViewModel);
        removeFriendPresenter.prepareFailView();
        assertTrue(followedFriendsViewState.friendUsernames.isEmpty());
    }
}
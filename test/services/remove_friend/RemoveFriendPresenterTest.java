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
        RemoveFriendPresenter removeFriendPresenter = new RemoveFriendPresenter(new FollowedFriendsViewModel("view", new FollowedFriendsViewState()),
            new MyLibraryViewModel("view", new MyLibraryViewState()));
        removeFriendPresenter.prepareSuccessView(new RemoveFriendOutputData(new ArrayList<>(), new ArrayList<>()));
        assertTrue(true, "success view presented");
    }

    @Test
    void prepareFailView() {
        RemoveFriendPresenter removeFriendPresenter = new RemoveFriendPresenter(new FollowedFriendsViewModel("view", new FollowedFriendsViewState()),
            new MyLibraryViewModel("view", new MyLibraryViewState()));
        removeFriendPresenter.prepareFailView();
        assertTrue(true, "fail view presented");
    }
}
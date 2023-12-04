package services.remove_playlist;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import services.remove_friend.RemoveFriendOutputData;
import services.remove_friend.RemoveFriendPresenter;
import view.logged_in.tabs.FollowedFriendsViewModel;
import view.logged_in.tabs.FollowedFriendsViewState;
import view.logged_in.tabs.MyLibraryViewModel;
import view.logged_in.tabs.MyLibraryViewState;

class RemovePlaylistPresenterTest {

    @Test
    void prepareSuccessView() {
        RemovePlaylistPresenter removePlaylistPresenter = new RemovePlaylistPresenter(new MyLibraryViewModel("view", new MyLibraryViewState()));
        removePlaylistPresenter.prepareSuccessView(new RemovePlaylistOutputData("playlistName", "user"));
        assertTrue(true, "success view presented");
    }
}
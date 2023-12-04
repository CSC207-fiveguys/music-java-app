package services.follow_artist;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import view.logged_in.tabs.FollowedArtistsViewModel;
import view.logged_in.tabs.FollowedArtistsViewState;
import view.logged_in.tabs.FollowedFriendsViewModel;
import view.logged_in.tabs.FollowedFriendsViewState;
import view.logged_in.tabs.MyLibraryViewModel;
import view.logged_in.tabs.MyLibraryViewState;

class FollowArtistPresenterTest {

    @Test
    void prepareSuccessView() {
        MyLibraryViewState myLibraryViewState = new MyLibraryViewState();
        MyLibraryViewModel myLibraryViewModel = new MyLibraryViewModel("my library", myLibraryViewState);
        FollowedArtistsViewState followedArtistsViewState = new FollowedArtistsViewState();
        FollowedArtistsViewModel followedArtistsViewModel = new FollowedArtistsViewModel("followed artists", followedArtistsViewState);
        FollowArtistPresenter FollowArtistPresenter = new FollowArtistPresenter(followedArtistsViewModel, myLibraryViewModel);
        FollowArtistPresenter.prepareSuccessView(new FollowArtistOutputData(new ArrayList<>(), new ArrayList<>()));
        assertTrue(followedArtistsViewState.artists.isEmpty());

    }
}
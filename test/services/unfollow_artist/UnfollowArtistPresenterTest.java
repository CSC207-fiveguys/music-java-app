package services.unfollow_artist;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import services.remove_track_from_liked.RemoveTrackFromLikedOutputData;
import services.remove_track_from_liked.RemoveTrackFromLikedPresenter;
import view.ViewManagerModel;
import view.logged_in.PlaylistViewModel;
import view.logged_in.PlaylistViewState;
import view.logged_in.tabs.FollowedArtistsViewModel;
import view.logged_in.tabs.FollowedArtistsViewState;

class UnfollowArtistPresenterTest {

    @Test
    void prepareSuccessView() {
        FollowedArtistsViewState followedArtistsViewState = new FollowedArtistsViewState();
        followedArtistsViewState.username = "user";
        FollowedArtistsViewModel followedArtistsViewModel = new FollowedArtistsViewModel("followed artists", followedArtistsViewState);
        UnfollowArtistPresenter presenter = new UnfollowArtistPresenter(followedArtistsViewModel);
        presenter.prepareSuccessView(new UnfollowArtistOutputData(new ArrayList<>()));
        assertNotNull(followedArtistsViewState.username);
    }
}
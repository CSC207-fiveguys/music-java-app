package view.logged_in;

import services.add_friend.AddFriendController;
import services.add_track_to_playlist.AddTrackToPlaylistController;
import services.create_new_playlist.CreateNewPlaylistController;
import services.follow_artist.FollowArtistController;
import services.like_track.LikeTrackController;
import services.remove_friend.RemoveFriendController;
import services.remove_playlist.RemovePlaylistController;
import services.search.SearchController;
import services.unfollow_artist.UnfollowArtistController;
import services.view_playlist.ViewPlaylistController;
import view.logged_in.tabs.*;

import javax.swing.*;

public class TabView extends JTabbedPane {
    // does not implement PropertyChangeListener because it just wraps the 4 TabPageViews
    // does not have a state because it just wraps the 4 TabPageViews

    private final TabViewModel tabViewModel;

    public TabView(TabViewModel tabViewModel,
                   MyLibraryViewModel myLibraryViewModel,
                   FollowedArtistsViewModel followedArtistsViewModel,
                   FollowedFriendsViewModel followedFriendsViewModel,
                   SearchViewModel searchViewModel,
                   CreateNewPlaylistController createNewPlaylistController,
                   ViewPlaylistController viewPlaylistController,
                   RemovePlaylistController removePlaylistController,
                   FollowArtistController followArtistController,
                   UnfollowArtistController unfollowArtistController,
                   AddFriendController addFriendController,
                   RemoveFriendController removeFriendController,
                   SearchController searchController,
                   LikeTrackController likeTrackController,
                   AddTrackToPlaylistController addTrackToPlaylistController) {
        this.tabViewModel = tabViewModel;

        MyLibraryView myLibraryView = new MyLibraryView(
                myLibraryViewModel,
                createNewPlaylistController,
                viewPlaylistController,
                removePlaylistController
        );
        add(myLibraryViewModel.viewName, myLibraryView);
        myLibraryViewModel.firePropertyChanged();


        FollowedArtistsView followedArtistsView = new FollowedArtistsView(
                followedArtistsViewModel,
                unfollowArtistController
        );
        add(followedArtistsViewModel.viewName, followedArtistsView);
        followedArtistsViewModel.firePropertyChanged();


        FollowedFriendsView followedFriendsView = new FollowedFriendsView(
                followedFriendsViewModel,
                removeFriendController
        );
        add(followedFriendsViewModel.viewName, followedFriendsView);
        followedFriendsViewModel.firePropertyChanged();


        SearchView searchView = new SearchView(
                searchViewModel,
                searchController,
                likeTrackController,
                addTrackToPlaylistController,
                followArtistController,
                addFriendController
        );
        add(searchViewModel.viewName, searchView);
        searchViewModel.firePropertyChanged();
    }
}

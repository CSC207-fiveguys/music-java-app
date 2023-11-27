package view.logged_in.tabs;

import services.add_friend.AddFriendController;
import services.add_track_to_playlist.AddTrackToPlaylistController;
import services.follow_artist.FollowArtistController;
import services.like_track.LikeTrackController;
import services.search.SearchController;
import view.components.row_components.ArtistRowPanel;
import view.components.row_components.FriendRowPanel;
import view.components.row_components.TrackRowPanel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.util.Map;

public class SearchView extends TabPageView {

    private final SearchViewModel searchViewModel;
    private final JTextField searchField;
    private final SearchController searchController;
    private final LikeTrackController likeTrackController;
    private final AddTrackToPlaylistController addTrackToPlaylistController;
    private final FollowArtistController followArtistController;
    private final AddFriendController addFriendController;

    public SearchView(SearchViewModel searchViewModel,
                      SearchController searchController,
                      LikeTrackController likeTrackController,
                      AddTrackToPlaylistController addTrackToPlaylistController,
                      FollowArtistController followArtistController,
                      AddFriendController addFriendController
    ) {
        super(searchViewModel.state.username, searchViewModel.viewName);
        this.searchViewModel = searchViewModel;
        searchViewModel.addPropertyChangeListener(this);
        this.searchController = searchController;
        this.likeTrackController = likeTrackController;
        this.addTrackToPlaylistController = addTrackToPlaylistController;
        this.followArtistController = followArtistController;
        this.addFriendController = addFriendController;

        searchField = new JTextField(15);
        add(searchField, 0);

        JButton searchButton = new JButton(searchViewModel.state.searchButtonText);
        add(searchButton, 1);
        searchButton.addActionListener(e -> searchButtonPressed());
    }

    private void searchButtonPressed() {
        searchController.execute(searchField.getText());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // UPDATE ALL NON-FINAL STATE ATTRIBUTES TO VIEW

        usernameHeaderRowPanel.updateUsername(searchViewModel.state.username);

        // show tracks

        for (Map<String, Object> track : searchViewModel.state.tracks) {
            innerPanel.add(Box.createRigidArea(new Dimension(0, 4)));
            innerPanel.add(new TrackRowPanel(
                    (String) track.get("title"),
                    (String) track.get("iconPath"),
                    (String) track.get("artists"),
                    (Boolean) track.get("explicit"),
                    (String) track.get("duration"),
                    (String) track.get("id"),
                    searchViewModel.state.username,
                    null,
                    likeTrackController,
                    addTrackToPlaylistController,
                    null,
                    null
            ));
            innerPanel.add(Box.createRigidArea(new Dimension(0, 4)));
        }

        // show artists

        for (Map<String, String> artist : searchViewModel.state.artists) {
            innerPanel.add(Box.createRigidArea(new Dimension(0, 4)));
            innerPanel.add(new ArtistRowPanel(
                    artist.get("name"),
                    artist.get("followers"),
                    artist.get("iconPath"),
                    artist.get("id"),
                    searchViewModel.state.username,
                    followArtistController,
                    null
            ));
            innerPanel.add(Box.createRigidArea(new Dimension(0, 4)));
        }

        // show friends

        for (String username : searchViewModel.state.friendUsernames) {
            innerPanel.add(Box.createRigidArea(new Dimension(0, 4)));
            innerPanel.add(new FriendRowPanel(
                    username,
                    searchViewModel.state.username,
                    "src/icons/friend-icon.png",
                    addFriendController,
                    null
            ));
            innerPanel.add(Box.createRigidArea(new Dimension(0, 4)));
        }
    }
}

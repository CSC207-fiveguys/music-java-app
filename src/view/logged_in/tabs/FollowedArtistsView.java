package view.logged_in.tabs;

import services.unfollow_artist.UnfollowArtistController;
import view.components.row_components.ArtistRowPanel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.util.Map;

public class FollowedArtistsView extends TabPageView {

    private final FollowedArtistsViewModel followedArtistsViewModel;
    private final UnfollowArtistController unfollowArtistController;

    public FollowedArtistsView(FollowedArtistsViewModel followedArtistsViewModel, UnfollowArtistController unfollowArtistController) {
        super(followedArtistsViewModel.state.username, followedArtistsViewModel.viewName);
        this.followedArtistsViewModel = followedArtistsViewModel;
        followedArtistsViewModel.addPropertyChangeListener(this);
        this.unfollowArtistController = unfollowArtistController;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // UPDATE ALL NON-FINAL STATE ATTRIBUTES TO VIEW

        usernameHeaderRowPanel.updateUsername(followedArtistsViewModel.state.username);

        innerPanel.removeAll();
        innerPanel.revalidate();
        innerPanel.repaint();

        for (Map<String, String> artist : followedArtistsViewModel.state.artists) {
            innerPanel.add(Box.createRigidArea(new Dimension(0, 4)));
            innerPanel.add(new ArtistRowPanel(
                    artist.get("name"),
                    artist.get("followers"),
                    artist.get("iconPath"),
                    artist.get("id"),
                    followedArtistsViewModel.state.username,
                    null,
                    unfollowArtistController
            ));
            innerPanel.add(Box.createRigidArea(new Dimension(0, 4)));
        }
    }
}

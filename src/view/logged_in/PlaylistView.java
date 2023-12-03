package view.logged_in;

import services.back_to_tab_view.BackToTabViewController;
import services.remove_track_from_liked.RemoveTrackFromLikedController;
import services.remove_track_from_playlist.RemoveTrackFromPlaylistController;
import view.components.row_components.TrackRowPanel;
import view.logged_in.tabs.TabPageView;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.util.Map;

public class PlaylistView extends TabPageView {

    private final PlaylistViewModel playlistViewModel;
    private final BackToTabViewController backToTabViewController;
    private final RemoveTrackFromLikedController removeTrackFromLikedController; // can be null if not viewing liked tracks
    private final RemoveTrackFromPlaylistController removeTrackFromPlaylistController; // can be null if viewing liked tracks


    public PlaylistView(PlaylistViewModel playlistViewModel,
                        BackToTabViewController backToTabViewController,
                        RemoveTrackFromLikedController removeTrackFromLikedController,
                        RemoveTrackFromPlaylistController removeTrackFromPlaylistController) {
        super(playlistViewModel.state.username, playlistViewModel.viewName);
        this.playlistViewModel = playlistViewModel;
        playlistViewModel.addPropertyChangeListener(this);
        this.backToTabViewController = backToTabViewController;
        this.removeTrackFromLikedController = removeTrackFromLikedController;
        this.removeTrackFromPlaylistController = removeTrackFromPlaylistController;

        JButton backButton = new JButton("back");
        backButton.addActionListener(e -> backButtonPressed());
        add(backButton);
    }

    private void backButtonPressed() {
        backToTabViewController.execute();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // UPDATE ALL NON-FINAL STATE ATTRIBUTES TO VIEW
        usernameHeaderRowPanel.updateUsername(playlistViewModel.state.username);

        innerPanel.removeAll();
        innerPanel.revalidate();
        innerPanel.repaint();

        if (playlistViewModel.state.isShowingLikedTracks) {
            for (Map<String, Object> track : playlistViewModel.state.tracks) {
                innerPanel.add(Box.createRigidArea(new Dimension(0, 4)));
                innerPanel.add(new TrackRowPanel(
                        (String) track.get("title"),
                        (String) track.get("iconPath"),
                        (String) track.get("artists"),
                        (Boolean) track.get("explicit"),
                        (String) track.get("duration"),
                        (String) track.get("id"),
                        playlistViewModel.state.username,
                        playlistViewModel.state.playlistName,
                        null,
                        null,
                        removeTrackFromLikedController,
                        null
                ));
                innerPanel.add(Box.createRigidArea(new Dimension(0, 4)));
            }
        }

        if (!playlistViewModel.state.isShowingLikedTracks) {
            for (Map<String, Object> track : playlistViewModel.state.tracks) {
                innerPanel.add(Box.createRigidArea(new Dimension(0, 4)));
                innerPanel.add(new TrackRowPanel(
                        (String) track.get("title"),
                        (String) track.get("iconPath"),
                        (String) track.get("artists"),
                        (Boolean) track.get("explicit"),
                        (String) track.get("duration"),
                        (String) track.get("id"),
                        playlistViewModel.state.username,
                        playlistViewModel.state.playlistName,
                        null,
                        null,
                        null,
                        removeTrackFromPlaylistController
                ));
                innerPanel.add(Box.createRigidArea(new Dimension(0, 4)));
            }
        }
    }
}

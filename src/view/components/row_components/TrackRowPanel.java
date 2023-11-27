package view.components.row_components;

import services.add_track_to_playlist.AddTrackToPlaylistController;
import services.like_track.LikeTrackController;
import services.remove_track_from_liked.RemoveTrackFromLikedController;
import services.remove_track_from_playlist.RemoveTrackFromPlaylistController;
import view.components.LabelTextPanel;

import javax.swing.*;
import java.awt.*;

public class TrackRowPanel extends ListedRowPanel {

    private final String id;
    private final String username;
    private final LikeTrackController likeTrackController;
    private JTextField playlistNameField = null;
    private final AddTrackToPlaylistController addTrackToPlaylistController;
    private final RemoveTrackFromLikedController removeTrackFromLikedController;
    private final String playlistName;
    private final RemoveTrackFromPlaylistController removeTrackFromPlaylistController;


    public TrackRowPanel(String title,
                         String iconPath,
                         String artists,
                         Boolean explicit,
                         String duration,
                         String id,
                         String username,
                         String playlistName, // can be null if track is not in playlist yet
                         LikeTrackController likeTrackController,
                         AddTrackToPlaylistController addTrackToPlaylistController,
                         RemoveTrackFromLikedController removeTrackFromLikedController,
                         RemoveTrackFromPlaylistController removeTrackFromPlaylistController) {
        super(title, iconPath);
        this.id = id;
        this.username = username;
        this.likeTrackController = likeTrackController;
        this.addTrackToPlaylistController = addTrackToPlaylistController;
        this.removeTrackFromLikedController = removeTrackFromLikedController;
        this.playlistName = playlistName;
        this.removeTrackFromPlaylistController = removeTrackFromPlaylistController;

        JLabel artistsLabel = new JLabel(artists);
        artistsLabel.setMinimumSize(new Dimension(180, 52));
        artistsLabel.setPreferredSize(new Dimension(180, 52));
        artistsLabel.setMaximumSize(new Dimension(180, 52));
        artistsLabel.setOpaque(true);
        artistsLabel.setBackground(Color.GRAY);
        add(artistsLabel);

        if (explicit) {
            JLabel explicitLabel = new JLabel("E");
            explicitLabel.setMinimumSize(new Dimension(10, 52));
            explicitLabel.setPreferredSize(new Dimension(10, 52));
            explicitLabel.setMaximumSize(new Dimension(10, 52));
            explicitLabel.setOpaque(true);
            explicitLabel.setBackground(Color.RED);
            add(explicitLabel);
        }

        JLabel durationLabel = new JLabel(duration);
        durationLabel.setMinimumSize(new Dimension(180, 52));
        durationLabel.setPreferredSize(new Dimension(180, 52));
        durationLabel.setMaximumSize(new Dimension(180, 52));
        durationLabel.setOpaque(true);
        durationLabel.setBackground(Color.GRAY);
        add(durationLabel);

        if (likeTrackController != null) {
            JButton likeButton = new JButton("like");
            likeButton.addActionListener(e -> likeButtonPressed());
            add(likeButton);
        }

        if (addTrackToPlaylistController != null) {
            playlistNameField = new JTextField(15);
            LabelTextPanel passwordPanel = new LabelTextPanel(
                    new JLabel("playlist to add to:"), playlistNameField);
            add(passwordPanel);

            JButton addToPlaylistButton = new JButton("add to playlist");
            add(addToPlaylistButton);
            addToPlaylistButton.addActionListener(e -> addToPlaylistButtonPressed());
        }

        if (removeTrackFromLikedController != null) {
            JButton unlikeButton = new JButton("unlike");
            unlikeButton.addActionListener(e -> unlikeButtonPressed());
            add(unlikeButton);
        }

        if (removeTrackFromPlaylistController != null) {
            JButton removeButton = new JButton("remove");
            removeButton.addActionListener(e -> removeButtonPressed());
            add(removeButton);
        }
    }

    private void likeButtonPressed() {
        likeTrackController.execute(id, username);
    }

    private void addToPlaylistButtonPressed() {
        addTrackToPlaylistController.execute(id, username, playlistNameField.getText());
    }

    private void unlikeButtonPressed() {
        removeTrackFromLikedController.execute(id, username);
    }

    private void removeButtonPressed() {
        removeTrackFromPlaylistController.execute(id, username, playlistName);
    }

}

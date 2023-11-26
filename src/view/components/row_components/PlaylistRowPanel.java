package view.components.row_components;

import services.remove_playlist.RemovePlaylistController;
import services.view_playlist.ViewPlaylistController;

import javax.swing.*;
import java.awt.*;

public class PlaylistRowPanel extends ListedRowPanel {

    private final String title;
    private final String owner;
    private final String username;
    private final Boolean isLikedTracks;
    private final ViewPlaylistController viewPlaylistController;
    private final RemovePlaylistController removePlaylistController;

    public PlaylistRowPanel(String title,
                            String owner,
                            String iconPath,
                            String username,
                            Boolean isLikedTracks,
                            ViewPlaylistController viewPlaylistController,
                            RemovePlaylistController removePlaylistController) {
        super(title, iconPath);
        this.title = title;
        this.owner = owner;
        this.username = username;
        this.isLikedTracks = isLikedTracks;
        this.viewPlaylistController = viewPlaylistController;
        this.removePlaylistController = removePlaylistController;

        JLabel label = new JLabel("Owned by \"" + owner + "\"");
        label.setMinimumSize(new Dimension(180, 52));
        label.setPreferredSize(new Dimension(180, 52));
        label.setMaximumSize(new Dimension(180, 52));
        label.setOpaque(true);
        label.setBackground(Color.GRAY);
        add(label);

        JButton viewButton = new JButton("view");
        viewButton.addActionListener(e -> viewButtonPressed());
        add(viewButton);

        if (removePlaylistController != null) {
            JButton addButton = new JButton("remove playlist");
            addButton.addActionListener(e -> removeButtonPressed());
            add(addButton);
        }
    }

    private void viewButtonPressed() {
        viewPlaylistController.execute(title, owner, isLikedTracks);
    }

    private void removeButtonPressed() {
        removePlaylistController.execute(title, owner, username);
    }

}

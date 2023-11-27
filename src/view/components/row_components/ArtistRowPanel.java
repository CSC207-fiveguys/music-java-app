package view.components.row_components;

import services.follow_artist.FollowArtistController;
import services.unfollow_artist.UnfollowArtistController;

import javax.swing.*;
import java.awt.*;

public class ArtistRowPanel extends ListedRowPanel {

    private final String id;
    private final String username;
    private final FollowArtistController followArtistController;
    private final UnfollowArtistController unfollowArtistController;

    public ArtistRowPanel(String name,
                          String followers,
                          String iconPath,
                          String id,
                          String username,
                          FollowArtistController followArtistController,
                          UnfollowArtistController unfollowArtistController) {
        super(name, iconPath);
        this.id = id;
        this.username = username;
        this.followArtistController = followArtistController;
        this.unfollowArtistController = unfollowArtistController;

        JLabel label = new JLabel(followers + " followers");
        label.setMinimumSize(new Dimension(180, 52));
        label.setPreferredSize(new Dimension(180, 52));
        label.setMaximumSize(new Dimension(180, 52));
        label.setOpaque(true);
        label.setBackground(Color.GRAY);
        add(label);

        if (followArtistController != null) {
            JButton followButton = new JButton("follow");
            followButton.addActionListener(e -> followButtonPressed());
            add(followButton);
        }

        if (unfollowArtistController != null) {
            JButton unfollowButton = new JButton("unfollow");
            unfollowButton.addActionListener(e -> unfollowButtonPressed());
            add(unfollowButton);
        }

    }

    private void followButtonPressed() {
        followArtistController.execute(id, username);
    }

    private void unfollowButtonPressed() {
        unfollowArtistController.execute(id, username);
    }

}

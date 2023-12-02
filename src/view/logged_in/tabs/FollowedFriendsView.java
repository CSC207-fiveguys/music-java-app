package view.logged_in.tabs;

import services.remove_friend.RemoveFriendController;
import view.components.row_components.FriendRowPanel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;

public class FollowedFriendsView extends TabPageView {

    private final FollowedFriendsViewModel followedFriendsViewModel;
    private final RemoveFriendController removeFriendController;

    public FollowedFriendsView(FollowedFriendsViewModel followedFriendsViewModel, RemoveFriendController removeFriendController) {
        super(followedFriendsViewModel.state.username, followedFriendsViewModel.viewName);
        this.followedFriendsViewModel = followedFriendsViewModel;
        followedFriendsViewModel.addPropertyChangeListener(this);
        this.removeFriendController = removeFriendController;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // UPDATE ALL NON-FINAL STATE ATTRIBUTES TO VIEW

        usernameHeaderRowPanel.updateUsername(followedFriendsViewModel.state.username);

        innerPanel.removeAll();

        for (String username : followedFriendsViewModel.state.friendUsernames) {
            innerPanel.add(Box.createRigidArea(new Dimension(0, 4)));
            innerPanel.add(new FriendRowPanel(
                    username,
                    followedFriendsViewModel.state.username,
                    "src/icons/friend-icon.png",
                    null,
                    removeFriendController
            ));
            innerPanel.add(Box.createRigidArea(new Dimension(0, 4)));
        }
    }
}

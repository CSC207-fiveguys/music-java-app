package view.components.row_components;

import services.add_friend.AddFriendController;
import services.remove_friend.RemoveFriendController;

import javax.swing.*;

public class FriendRowPanel extends ListedRowPanel {

    private final String friendUsername;
    private final String username;
    private final AddFriendController addFriendController;
    private final RemoveFriendController removeFriendController;

    public FriendRowPanel(String friendUsername,
                          String username,
                          String iconPath,
                          AddFriendController addFriendController,
                          RemoveFriendController removeFriendController) {
        super(friendUsername, iconPath);
        this.friendUsername = friendUsername;
        this.username = username;
        this.addFriendController = addFriendController;
        this.removeFriendController = removeFriendController;

        if (addFriendController != null) {
            JButton addButton = new JButton("add friend");
            addButton.addActionListener(e -> addButtonPressed());
            add(addButton);
        }

        if (removeFriendController != null) {
            JButton removeButton = new JButton("remove friend");
            removeButton.addActionListener(e -> removeButtonPressed());
            add(removeButton);
        }
    }

    private void addButtonPressed() {
        addFriendController.execute(friendUsername, username);
    }

    private void removeButtonPressed() {
        removeFriendController.execute(friendUsername, username);
    }

}

package view.logged_in.tabs;

import services.create_new_playlist.CreateNewPlaylistController;
import services.remove_playlist.RemovePlaylistController;
import services.view_playlist.ViewPlaylistController;
import view.components.LabelTextPanel;
import view.components.row_components.PlaylistRowPanel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.util.Map;

public class MyLibraryView extends TabPageView {

    private final MyLibraryViewModel myLibraryViewModel;
    private final JTextField newPlaylistNameField;
    private final CreateNewPlaylistController createNewPlaylistController;
    private final ViewPlaylistController viewPlaylistController;
    private final RemovePlaylistController removePlaylistController;

    public MyLibraryView(MyLibraryViewModel myLibraryViewModel,
                         CreateNewPlaylistController createNewPlaylistController,
                         ViewPlaylistController viewPlaylistController,
                         RemovePlaylistController removePlaylistController) {
        super(myLibraryViewModel.state.username, myLibraryViewModel.viewName);
        this.myLibraryViewModel = myLibraryViewModel;
        myLibraryViewModel.addPropertyChangeListener(this);
        this.createNewPlaylistController = createNewPlaylistController;
        this.viewPlaylistController = viewPlaylistController;
        this.removePlaylistController = removePlaylistController;

        newPlaylistNameField = new JTextField(15);
        LabelTextPanel newPlaylistPanel = new LabelTextPanel(
                new JLabel(myLibraryViewModel.state.newPlaylistNameText), newPlaylistNameField);
        add(newPlaylistPanel);

        JButton newPlaylistButton = new JButton(myLibraryViewModel.state.newPlaylistButtonText);
        add(newPlaylistButton);
        newPlaylistButton.addActionListener(e -> newPlaylistButtonPressed());
    }

    private void newPlaylistButtonPressed() {
        createNewPlaylistController.execute(newPlaylistNameField.getText(), myLibraryViewModel.state.username);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // UPDATE ALL NON-FINAL STATE ATTRIBUTES TO VIEW
        usernameHeaderRowPanel.updateUsername(myLibraryViewModel.state.username);

        innerPanel.removeAll();

        innerPanel.add(Box.createRigidArea(new Dimension(0, 4)));
        innerPanel.add(new PlaylistRowPanel(
                "Liked Tracks",
                myLibraryViewModel.state.username,
                "src/icons/liked-tracks-icon.png",
                myLibraryViewModel.state.username,
                true,
                viewPlaylistController,
                null
        ));
        innerPanel.add(Box.createRigidArea(new Dimension(0, 4)));

        for (Map<String, String> playlist : myLibraryViewModel.state.personalPlaylists) {
            innerPanel.add(Box.createRigidArea(new Dimension(0, 4)));
            innerPanel.add(new PlaylistRowPanel(
                    playlist.get("title"),
                    playlist.get("owner"),
                    "src/icons/playlist-icon.png",
                    myLibraryViewModel.state.username,
                    false,
                    viewPlaylistController,
                    removePlaylistController
            ));
            innerPanel.add(Box.createRigidArea(new Dimension(0, 4)));
        }
    }
}

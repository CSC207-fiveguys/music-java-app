package services.remove_playlist;

import data_access.UserDataAccessObject;
import entities.Playlist;
import entities.User;
import java.util.Objects;

public class RemovePlaylistInteractor implements RemovePlaylistInputBoundary {

    final RemovePlaylistDataAccessInterface userDataAccessObject;
    final RemovePlaylistOutputBoundary removePlaylistPresenter;

    public RemovePlaylistInteractor(RemovePlaylistDataAccessInterface userDataAccessObject,
        RemovePlaylistOutputBoundary removePlaylistOutputBoundary) {
        this.userDataAccessObject = userDataAccessObject;
        this.removePlaylistPresenter = removePlaylistOutputBoundary;
    }

    @Override
    public void execute(RemovePlaylistInputData removePlaylistInputData) {
        User user = userDataAccessObject.getUser(removePlaylistInputData.removeFromUsername);
        String playlistname = removePlaylistInputData.playlistName;
        user.removePlaylist(playlistname);
        RemovePlaylistOutputData removePlaylistOutputData = new RemovePlaylistOutputData(
            playlistname,
            removePlaylistInputData.removeFromUsername);
        removePlaylistPresenter.prepareSuccessView(removePlaylistOutputData);
    }

}

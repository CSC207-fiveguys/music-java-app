package services.remove_track_from_playlist;

import entities.Playlist;
import entities.User;

import java.util.ArrayList;

public class RemoveTrackFromPlaylistInteractor implements RemoveTrackFromPlaylistInputBoundary {
    final RemoveTrackFromPlaylistUserDataAccessInterface userDataAccessObject;
    final RemoveTrackFromPlaylistOutputBoundary removeTrackFromPlaylistPresenter;

    public RemoveTrackFromPlaylistInteractor(RemoveTrackFromPlaylistUserDataAccessInterface userDataAccessObject,
                                             RemoveTrackFromPlaylistOutputBoundary removeTrackFromPlaylistPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.removeTrackFromPlaylistPresenter = removeTrackFromPlaylistPresenter;
    }

    public void execute(RemoveTrackFromPlaylistInputData removeTrackFromPlaylistInputData) {
        String id = removeTrackFromPlaylistInputData.id;
        String username = removeTrackFromPlaylistInputData.username;
        String playlist = removeTrackFromPlaylistInputData.playlistName;

        User user = userDataAccessObject.getUser(username);

        ArrayList<Playlist> playlists = user.getPlaylists();

        for (Playlist curr_playlist : playlists) {
            if (curr_playlist.getName().equals(playlist)) {
                curr_playlist.removeTrack(id);

                RemoveTrackFromPlaylistOutputData removeTrackFromPlaylistOutputData = new
                        RemoveTrackFromPlaylistOutputData(id);

                removeTrackFromPlaylistPresenter.prepareSuccessView(removeTrackFromPlaylistOutputData);

                break;
            }
        }
    }
}

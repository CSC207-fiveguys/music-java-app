package services.add_track_to_playlist;

import entities.Playlist;
import entities.User;
import java.util.ArrayList;

public class AddTrackToPlaylistInteractor implements AddTrackToPlaylistInputBoundary{
    final AddTrackToPlaylistUserDataAccessInterface userDataAccessObject;
    final AddTrackToPlaylistSpotifyDataAccessInterface spotifyDataAccessObject;
    final AddTrackToPlaylistOutputBoundary addTrackToPlaylistPresenter;

    public AddTrackToPlaylistInteractor(
          AddTrackToPlaylistUserDataAccessInterface userDataAccessObject,
          AddTrackToPlaylistSpotifyDataAccessInterface spotifyDataAccessObject,
          AddTrackToPlaylistOutputBoundary addTrackToPlaylistPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.spotifyDataAccessObject = spotifyDataAccessObject;
        this.addTrackToPlaylistPresenter = addTrackToPlaylistPresenter;
    }

    public void execute(AddTrackToPlaylistInputData addTrackToPlaylistInputData) {
        String id = addTrackToPlaylistInputData.id;
        String username = addTrackToPlaylistInputData.username;
        String playlistName = addTrackToPlaylistInputData.playlistName;

        User user = userDataAccessObject.getUser(username);

        ArrayList<Playlist> playlists = user.getPlaylists();

        for (Playlist curr_playlist : playlists) {
            if (curr_playlist.getName().equals(playlistName)) {
                spotifyDataAccessObject.saveTrack(id);
                curr_playlist.addTrack(id);
                addTrackToPlaylistPresenter.prepareSuccessView();
            }
        }
    }
}

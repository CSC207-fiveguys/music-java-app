package services.add_track_to_playlist;

public class AddTrackToPlaylistController {
    final AddTrackToPlaylistInputBoundary addTrackToPlaylistInteractor;

    public AddTrackToPlaylistController(
        AddTrackToPlaylistInputBoundary addTrackToPlaylistInteractor) {
        this.addTrackToPlaylistInteractor = addTrackToPlaylistInteractor;
    }

    public void execute(String id, String username, String playlistName) {
        AddTrackToPlaylistInputData addTrackToPlaylistInputData = new AddTrackToPlaylistInputData(
            id, username, playlistName);

        addTrackToPlaylistInteractor.execute(addTrackToPlaylistInputData);
    }
}

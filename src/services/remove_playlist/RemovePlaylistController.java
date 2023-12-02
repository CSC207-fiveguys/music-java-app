package services.remove_playlist;

public class RemovePlaylistController {

    final RemovePlaylistInputBoundary removePlaylistInteractor;

    public RemovePlaylistController(RemovePlaylistInputBoundary removePlaylistInteractor) {
        this.removePlaylistInteractor = removePlaylistInteractor;
    }

    public void execute(String playlistName, String ownerUsername, String removeFromUsername) {
        RemovePlaylistInputData removePlaylistInputData = new RemovePlaylistInputData(playlistName,
            ownerUsername, removeFromUsername);
        removePlaylistInteractor.execute(removePlaylistInputData);
    }
}

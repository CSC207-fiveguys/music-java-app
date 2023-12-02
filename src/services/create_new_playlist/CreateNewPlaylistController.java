package services.create_new_playlist;

public class CreateNewPlaylistController {

    final CreateNewPlaylistInputBoundary createNewPlaylistInteractor;

    public CreateNewPlaylistController(CreateNewPlaylistInputBoundary createNewPlaylistInteractor) {
        this.createNewPlaylistInteractor = createNewPlaylistInteractor;
    }
    public void execute(String playlistName, String username) {
        CreateNewPlaylistInputData createNewPlaylistInputData = new CreateNewPlaylistInputData(
            playlistName, username
        );

        createNewPlaylistInteractor.execute(createNewPlaylistInputData);
    }
}

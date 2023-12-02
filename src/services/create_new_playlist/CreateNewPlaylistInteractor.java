package services.create_new_playlist;

import data_access.UserDataAccessObject;
import entities.Playlist;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class CreateNewPlaylistInteractor implements CreateNewPlaylistInputBoundary{
    final CreateNewPlaylistDataAccessInterface userDataAccessObject;
    final CreateNewPlaylistOutputBoundary createNewPlaylistPresenter;

    public CreateNewPlaylistInteractor(CreateNewPlaylistDataAccessInterface userDataAccessObject,
        CreateNewPlaylistOutputBoundary createNewPlaylistOutputBoundary) {
        this.userDataAccessObject = userDataAccessObject;
        this.createNewPlaylistPresenter = createNewPlaylistOutputBoundary;
    }

    @Override
    public void execute(CreateNewPlaylistInputData createNewPlaylistInputData) {
        String playlistname = createNewPlaylistInputData.playlistName;
        String username = createNewPlaylistInputData.username;
        boolean exists = false;
        for (Playlist playlist : userDataAccessObject.getUser(username).getPlaylists()){
            if (Objects.equals(playlist.getName(), playlistname)) {
                exists = true;
            }
        }
        if (exists) {
            createNewPlaylistPresenter.prepareFailView(playlistname + "already exists");
        } else {
            userDataAccessObject.getUser(username).createPlaylist(playlistname);
            ArrayList<Map<String, Object>> tracks = new ArrayList<>();
            CreateNewPlaylistOutputData createNewPlaylistOutputData = new CreateNewPlaylistOutputData(username,
                playlistname,
                tracks);
            createNewPlaylistPresenter.prepareSuccessView(createNewPlaylistOutputData);
        }
    }
}

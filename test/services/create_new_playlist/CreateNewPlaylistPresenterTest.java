package services.create_new_playlist;

import static org.junit.jupiter.api.Assertions.*;

import data_access.ArtistDataAccessObject;
import data_access.SpotifyDataAccessObject;
import data_access.TrackDataAccessObject;
import data_access.UserDataAccessObject;
import entities.User;
import entities.UserFactory;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import services.add_track_to_playlist.AddTrackToPlaylistPresenter;
import view.logged_in.tabs.MyLibraryViewModel;
import view.logged_in.tabs.MyLibraryViewState;

class CreateNewPlaylistPresenterTest {

    @Test
    void prepareSuccessView() {
        MyLibraryViewState myLibraryViewState = new MyLibraryViewState();
        MyLibraryViewModel myLibraryViewModel = new MyLibraryViewModel("my library", myLibraryViewState);
        CreateNewPlaylistPresenter presenter = new CreateNewPlaylistPresenter(myLibraryViewModel);
        presenter.prepareSuccessView(new CreateNewPlaylistOutputData("username", "playlistname", new ArrayList<>()));
        assertFalse(myLibraryViewState.personalPlaylists.isEmpty());
    }

    @Test
    void prepareFailView() {
        TrackDataAccessObject trackDataAccessObject = new TrackDataAccessObject();
        ArtistDataAccessObject artistDataAccessObject = new ArtistDataAccessObject();
        SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject(trackDataAccessObject, artistDataAccessObject);
        UserFactory userFactory = new UserFactory();
        MyLibraryViewModel myLibraryViewModel = new MyLibraryViewModel("view", new MyLibraryViewState());
        UserDataAccessObject userDataAccessInterface = new UserDataAccessObject(userFactory, spotifyDataAccessObject);
        CreateNewPlaylistPresenter presenter = new CreateNewPlaylistPresenter(myLibraryViewModel);
        User user = userFactory.create("user", "123");
        userDataAccessInterface.saveUser(user);
        user.createPlaylist("playlistname");
        presenter.prepareFailView("Playlist already exists");
        assertTrue(myLibraryViewModel.state.personalPlaylists.isEmpty());
    }
}
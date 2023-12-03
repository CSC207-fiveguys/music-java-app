package services.remove_playlist;

import java.util.Map;
import java.util.Objects;
import view.ViewManagerModel;
import view.logged_in.PlaylistViewModel;
import view.logged_in.tabs.MyLibraryViewModel;
import view.logged_in.tabs.MyLibraryViewState;

public class RemovePlaylistPresenter implements RemovePlaylistOutputBoundary {

    private final MyLibraryViewModel myLibraryViewModel;

    public RemovePlaylistPresenter(MyLibraryViewModel myLibraryViewModel) {
        this.myLibraryViewModel = myLibraryViewModel;
    }

    public void prepareSuccessView(RemovePlaylistOutputData removePlaylistOutputData) {
        MyLibraryViewState myLibraryViewState = this.myLibraryViewModel.state;
        myLibraryViewState.username = removePlaylistOutputData.username;
        Map<String, String> removePlaylist = myLibraryViewState.personalPlaylists.stream()
            .filter(playlist -> Objects.equals(playlist.get("title"), removePlaylistOutputData.playlistname))
            .findFirst()
            .orElse(null);
        myLibraryViewState.personalPlaylists.remove(removePlaylist);
        myLibraryViewModel.firePropertyChanged();
    }

}

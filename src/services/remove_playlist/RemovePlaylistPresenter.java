package services.remove_playlist;

import java.util.Map;
import java.util.Objects;
import view.ViewManagerModel;
import view.logged_in.PlaylistViewModel;
import view.logged_in.tabs.MyLibraryViewModel;
import view.logged_in.tabs.MyLibraryViewState;

public class RemovePlaylistPresenter implements RemovePlaylistOutputBoundary {

    private final MyLibraryViewModel myLibraryViewModel;
    private ViewManagerModel viewManagerModel;

    public RemovePlaylistPresenter(MyLibraryViewModel myLibraryViewModel,
        ViewManagerModel viewManagerModel) {
        this.myLibraryViewModel = myLibraryViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    public void prepareSuccessView(RemovePlaylistOutputData removePlaylistOutputData) {
        MyLibraryViewState myLibraryViewState = this.myLibraryViewModel.state;
        myLibraryViewState.username = removePlaylistOutputData.username;
        Map<String, String> removePlaylist = null;
        for (Map<String, String> playlist : myLibraryViewState.personalPlaylists) {
            if (Objects.equals(playlist.get("title"), removePlaylistOutputData.playlistname)) {
                removePlaylist = playlist;
            }
        }
        myLibraryViewState.personalPlaylists.remove(removePlaylist);
        myLibraryViewModel.firePropertyChanged();
    }

}

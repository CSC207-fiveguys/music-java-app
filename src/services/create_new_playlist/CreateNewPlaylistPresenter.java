package services.create_new_playlist;

import java.util.Map;
import view.ViewManagerModel;
import view.logged_in.PlaylistViewModel;
import view.logged_in.PlaylistViewState;
import view.logged_in.tabs.MyLibraryViewModel;
import view.logged_in.tabs.MyLibraryViewState;

public class CreateNewPlaylistPresenter implements CreateNewPlaylistOutputBoundary {

    private final MyLibraryViewModel myLibraryViewModel;
    private ViewManagerModel viewManagerModel;

    public CreateNewPlaylistPresenter(ViewManagerModel viewManagerModel,
        MyLibraryViewModel myLibraryViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.myLibraryViewModel = myLibraryViewModel;
    }

    @Override
    public void prepareSuccessView(CreateNewPlaylistOutputData response) {
        MyLibraryViewState myLibraryViewState = myLibraryViewModel.state;
        myLibraryViewState.username = response.username;
        Map<String, String> newplaylist = Map.of(
            "title", response.playlistname,
            "owner", response.username
        );
        myLibraryViewState.personalPlaylists.add(newplaylist);
        myLibraryViewModel.firePropertyChanged();
    }

    public void prepareFailView(String error) {
        MyLibraryViewState myLibraryViewState = myLibraryViewModel.state;
        this.myLibraryViewModel.firePropertyChanged();
    }
}

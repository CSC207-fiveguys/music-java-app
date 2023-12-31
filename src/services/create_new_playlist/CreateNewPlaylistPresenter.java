package services.create_new_playlist;

import java.util.Map;
import view.logged_in.tabs.MyLibraryViewModel;
import view.logged_in.tabs.MyLibraryViewState;

public class CreateNewPlaylistPresenter implements CreateNewPlaylistOutputBoundary {

    private final MyLibraryViewModel myLibraryViewModel;

    public CreateNewPlaylistPresenter(MyLibraryViewModel myLibraryViewModel) {
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
        this.myLibraryViewModel.firePropertyChanged();
    }
}

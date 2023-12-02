package services.create_new_playlist;
import view.ViewManagerModel;
import view.logged_in.PlaylistViewModel;
import view.logged_in.PlaylistViewState;
import view.logged_in.tabs.MyLibraryViewModel;
import view.logged_in.tabs.MyLibraryViewState;

public class CreateNewPlaylistPresenter implements CreateNewPlaylistOutputBoundary{
    private final MyLibraryViewModel myLibraryViewModel;
    private final PlaylistViewModel playlistViewModel;
    private ViewManagerModel viewManagerModel;

    public CreateNewPlaylistPresenter(ViewManagerModel viewManagerModel,
        MyLibraryViewModel myLibraryViewModel,
        PlaylistViewModel playlistViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.myLibraryViewModel = myLibraryViewModel;
        this.playlistViewModel = playlistViewModel;
    }

    @Override
    public void prepareSuccessView(CreateNewPlaylistOutputData response) {
        PlaylistViewState playlistViewState = playlistViewModel.state;
        playlistViewState.username = response.username;
        playlistViewState.playlistName = response.playlistname;
        playlistViewState.tracks = response.tracks;
        this.playlistViewModel.firePropertyChanged();

        this.viewManagerModel.activeView = playlistViewModel.viewName;
        this.viewManagerModel.firePropertyChanged();
    }

    public void prepareFailView(String error) {
        MyLibraryViewState myLibraryViewState = myLibraryViewModel.state;
        this.myLibraryViewModel.firePropertyChanged();
    }
}

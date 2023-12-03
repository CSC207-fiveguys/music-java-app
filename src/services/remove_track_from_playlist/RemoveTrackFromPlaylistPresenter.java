package services.remove_track_from_playlist;

import view.ViewManagerModel;
import view.logged_in.PlaylistViewModel;

public class RemoveTrackFromPlaylistPresenter implements RemoveTrackFromPlaylistOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final PlaylistViewModel playlistViewModel;

    public RemoveTrackFromPlaylistPresenter(ViewManagerModel viewManagerModel, PlaylistViewModel playlistViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.playlistViewModel = playlistViewModel;
    }

    @Override
    public void prepareSuccessView(RemoveTrackFromPlaylistOutputData id) {
        playlistViewModel.state.tracks.remove(id);
        viewManagerModel.activeView = playlistViewModel.viewName;
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView() {}
}

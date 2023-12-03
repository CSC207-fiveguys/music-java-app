package services.remove_track_from_liked;

import view.ViewManagerModel;
import view.logged_in.PlaylistViewModel;

public class RemoveTrackFromLikedPresenter implements RemoveTrackFromLikedOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final PlaylistViewModel playlistViewModel;

    public RemoveTrackFromLikedPresenter(ViewManagerModel viewManagerModel, PlaylistViewModel playlistViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.playlistViewModel = playlistViewModel;
    }

    @Override
    public void prepareSuccessView(RemoveTrackFromLikedOutputData id) {
        playlistViewModel.state.tracks.remove(id);
        viewManagerModel.activeView = playlistViewModel.viewName;
        viewManagerModel.firePropertyChanged();
    }
    @Override
    public void prepareFailView() {}
}
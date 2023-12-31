package services.remove_track_from_playlist;

import view.ViewManagerModel;
import view.logged_in.PlaylistViewModel;

import java.util.Map;
import java.util.Objects;

public class RemoveTrackFromPlaylistPresenter implements RemoveTrackFromPlaylistOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final PlaylistViewModel playlistViewModel;

    public RemoveTrackFromPlaylistPresenter(ViewManagerModel viewManagerModel, PlaylistViewModel playlistViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.playlistViewModel = playlistViewModel;
    }

    @Override
    public void prepareSuccessView(RemoveTrackFromPlaylistOutputData id) {

        for (Map<String, Object> track : playlistViewModel.state.tracks) {
            if (Objects.equals((String) track.get("id"), id.id)) {
                playlistViewModel.state.tracks.remove(track);
                break;
            }
        }

        playlistViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView() {}
}
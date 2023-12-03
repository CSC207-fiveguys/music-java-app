package services.remove_track_from_liked;

import view.ViewManagerModel;
import view.logged_in.PlaylistViewModel;

import java.util.Map;
import java.util.Objects;

public class RemoveTrackFromLikedPresenter implements RemoveTrackFromLikedOutputBoundary {
    private final ViewManagerModel viewManagerModel;
    private final PlaylistViewModel playlistViewModel;

    public RemoveTrackFromLikedPresenter(ViewManagerModel viewManagerModel, PlaylistViewModel playlistViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.playlistViewModel = playlistViewModel;
    }

    @Override
    public void prepareSuccessView(RemoveTrackFromLikedOutputData id) {

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
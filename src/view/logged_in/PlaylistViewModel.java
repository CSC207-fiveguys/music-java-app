package view.logged_in;

import view.ViewModel;

public class PlaylistViewModel extends ViewModel {

    public final PlaylistViewState state;

    public PlaylistViewModel(String viewName, PlaylistViewState playlistViewState) {
        super(viewName);
        this.state = playlistViewState;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, state);
    }

}

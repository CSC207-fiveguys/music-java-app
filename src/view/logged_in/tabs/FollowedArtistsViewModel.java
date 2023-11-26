package view.logged_in.tabs;

import view.ViewModel;

public class FollowedArtistsViewModel extends ViewModel {

    public final FollowedArtistsViewState state;

    public FollowedArtistsViewModel(String viewName, FollowedArtistsViewState state) {
        super(viewName);
        this.state = state;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, state);
    }

}

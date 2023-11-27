package view.logged_in.tabs;

import view.ViewModel;

public class FollowedFriendsViewModel extends ViewModel {

    public final FollowedFriendsViewState state;

    public FollowedFriendsViewModel(String viewName, FollowedFriendsViewState followedFriendsViewState) {
        super(viewName);
        this.state = followedFriendsViewState;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, state);
    }

}

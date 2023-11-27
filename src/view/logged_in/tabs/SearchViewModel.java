package view.logged_in.tabs;

import view.ViewModel;

public class SearchViewModel extends ViewModel {

    public final SearchViewState state;

    public SearchViewModel(String viewName, SearchViewState searchViewState) {
        super(viewName);
        this.state = searchViewState;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, state);
    }

}

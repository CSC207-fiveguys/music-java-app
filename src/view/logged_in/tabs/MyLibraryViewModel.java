package view.logged_in.tabs;

import view.ViewModel;

public class MyLibraryViewModel extends ViewModel {

    public final MyLibraryViewState state;

    public MyLibraryViewModel(String viewName, MyLibraryViewState state) {
        super(viewName);
        this.state = state;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, state);
    }

}

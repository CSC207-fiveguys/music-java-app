package view.logged_out;

import view.ViewModel;

public class SignupViewModel extends ViewModel {

    public final SignupViewState state;

    public SignupViewModel(String viewName, SignupViewState state) {
        super(viewName);
        this.state = state;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, state);
    }

}

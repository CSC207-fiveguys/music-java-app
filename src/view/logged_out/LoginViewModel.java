package view.logged_out;

import view.ViewModel;

public class LoginViewModel extends ViewModel {

    public final LoginViewState state;

    public LoginViewModel(String viewName, LoginViewState state) {
        super(viewName);
        this.state = state;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, state);
    }

}

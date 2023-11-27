package services.signup_abort;

import view.ViewManagerModel;
import view.logged_out.LoginViewModel;

public class SignupAbortPresenter implements SignupAbortOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final ViewManagerModel viewManagerModel;

    public SignupAbortPresenter(LoginViewModel loginViewModel,
                                ViewManagerModel viewManagerModel) {
        this.loginViewModel = loginViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView() {
        viewManagerModel.activeView = loginViewModel.viewName;
        viewManagerModel.firePropertyChanged();

    }
}

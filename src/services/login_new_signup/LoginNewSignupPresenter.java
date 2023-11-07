package services.login_new_signup;

import view.ViewManagerModel;
import view.logged_out.LoginViewModel;
import view.logged_out.SignupViewModel;

public class LoginNewSignupPresenter implements LoginNewSignupOutputBoundary{
    private final SignupViewModel signupViewModel;
    private final ViewManagerModel viewManagerModel;

    public LoginNewSignupPresenter(SignupViewModel signupViewModel,
                                   ViewManagerModel viewManagerModel) {
        this.signupViewModel = signupViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void presentSignupView() {
        viewManagerModel.activeView = signupViewModel.viewName;
        viewManagerModel.firePropertyChanged();
    }
}

package services.signup_complete;

import view.ViewManagerModel;
import view.logged_out.LoginViewModel;
import view.logged_out.SignupViewModel;

public class SignupCompletePresenter implements SignupCompleteOutputBoundary{

    private final SignupViewModel signupViewModel;
    private final LoginViewModel loginViewModel;
    private final ViewManagerModel viewManagerModel;


    public SignupCompletePresenter(SignupViewModel signupViewModel,
                                   LoginViewModel loginViewModel,
                                   ViewManagerModel viewManagerModel) {
        this.signupViewModel = signupViewModel;
        this.loginViewModel = loginViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(SignupCompleteOutputData response){
        viewManagerModel.activeView = loginViewModel.viewName;
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error){
        viewManagerModel.activeView = signupViewModel.viewName;
    }
}

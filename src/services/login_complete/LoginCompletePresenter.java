package services.login_complete;

import view.ViewManagerModel;
import view.logged_in.TabViewModel;
import view.logged_out.LoginViewModel;

public class LoginCompletePresenter implements LoginCompleteOutputBoundary {
    private final LoginViewModel loginViewModel;

    private final TabViewModel tabViewModel;

    private ViewManagerModel viewManagerModel;

    public LoginCompletePresenter(ViewManagerModel viewManagerModel,
                                  LoginViewModel loginViewModel,
                                  TabViewModel tabViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loginViewModel = loginViewModel;
        this.tabViewModel = tabViewModel;
    }

    @Override
    public void prepareSuccessView(LoginCompleteOutputData response){
        viewManagerModel.activeView = tabViewModel.viewName;
        viewManagerModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String error) {
        viewManagerModel.activeView = loginViewModel.viewName;
         // How do we set the user-name error, as we don't have a state
    }
}

package services.login_new_signup;

public class LoginNewSignupInteractor implements LoginNewSignupInputBoundary{
    final LoginNewSignupOutputBoundary userPresenter;
    final LoginNewSignupUserDataAccessInterface userDataAccess;
    public LoginNewSignupInteractor(LoginNewSignupOutputBoundary loginNewSignupOutputBoundary,
                                    LoginNewSignupUserDataAccessInterface userDataAccess) {
        this.userPresenter = loginNewSignupOutputBoundary;
        this.userDataAccess = userDataAccess;
    }

    @Override
    public void initiateSignupProcess() {
        LoginNewSignupOutputData loginNewSignupOutputData = new LoginNewSignupOutputData();
        userPresenter.presentSignupView(loginNewSignupOutputData);
    }
}

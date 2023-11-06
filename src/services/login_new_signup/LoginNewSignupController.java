package services.login_new_signup;
public class LoginNewSignupController {

    final LoginNewSignupInputBoundary loginNewSignupUseCaseInteractor;

    public LoginNewSignupController(LoginNewSignupInputBoundary loginNewSignupUseCaseInteractor) {
        this.loginNewSignupUseCaseInteractor = loginNewSignupUseCaseInteractor;
    }

    public void goToSignup() {
        loginNewSignupUseCaseInteractor.initiateSignupProcess();
    }
}

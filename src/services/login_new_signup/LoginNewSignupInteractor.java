package services.login_new_signup;

public class LoginNewSignupInteractor implements LoginNewSignupInputBoundary {

  final LoginNewSignupOutputBoundary userPresenter;

  public LoginNewSignupInteractor(LoginNewSignupOutputBoundary loginNewSignupOutputBoundary) {
    this.userPresenter = loginNewSignupOutputBoundary;
  }

  @Override
  public void execute() {
    userPresenter.prepareSuccessView();
  }
}
package services.signup_abort;

public class SignupAbortInteractor implements SignupAbortInputBoundary {

  private SignupAbortOutputBoundary userPresenter;

  public SignupAbortInteractor(SignupAbortOutputBoundary outputBoundary) {
    this.userPresenter = outputBoundary;
  }

  @Override
  public void execute() {
    userPresenter.presentLoginView();
  }
}

package services.signup_abort;

public class SignupAbortInteractor implements SignupAbortInputBoundary {

    final SignupAbortOutputBoundary userPresenter;

    public SignupAbortInteractor(SignupAbortOutputBoundary outputBoundary) {
        this.userPresenter = outputBoundary;
    }

    @Override
    public void execute() {
        userPresenter.prepareSuccessView();
    }
}

package services.signup_abort;

public class SignupAbortInteractor implements SignupAbortInputBoundary{
    private SignupAbortOutputBoundary userPresenter;
    private SignupAbortUserDataAccessInterface userDataAccess;

    public SignupAbortInteractor(
            SignupAbortOutputBoundary outputBoundary,
            SignupAbortUserDataAccessInterface userDataAccess
    ) {
        this.userPresenter = outputBoundary;
        this.userDataAccess = userDataAccess;
    }

    @Override
    public void initiateLoginProcess() {
        SignupAbortOutputData signupAbortOutputData = new SignupAbortOutputData();
        userPresenter.presentLoginView(signupAbortOutputData);
    }
}

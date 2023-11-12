package services.signup_complete;

public class SignupCompleteInteractor implements SignupCompleteInputBoundary{
    final SignupCompleteUserDataAccessInterface userDataAccessObject;
    final SignupCompleteOutputBoundary signupCompletePresenter;

    public SignupCompleteInteractor(SignupCompleteUserDataAccessInterface userDataAccessObject,
                                    SignupCompleteOutputBoundary signupCompletePresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.signupCompletePresenter = signupCompletePresenter;
    }

    @Override
    public void execute(SignupCompleteInputData signupCompleteInputData) {
        String username = signupCompleteInputData.getUsername();
        String password = signupCompleteInputData.getPassword();

        if (!userDataAccessObject.existsByName(username)){
            signupCompletePresenter.prepareFailView(username +
                    " is taken. Please choose a different username.");
        } else{
            userDataAccessObject.save(username, password);

            SignupCompleteOutputData signupCompleteOutputData = new SignupCompleteOutputData(username);

            signupCompletePresenter.prepareSuccessView(signupCompleteOutputData);
        }
    }
}

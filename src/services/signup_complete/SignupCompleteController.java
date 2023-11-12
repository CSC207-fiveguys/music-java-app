package services.signup_complete;
public class SignupCompleteController {
    final SignupCompleteInputBoundary signupUseCaseInteractor;

    public SignupCompleteController(SignupCompleteInputBoundary signupUseCaseInteractor) {
        this.signupUseCaseInteractor = signupUseCaseInteractor;
    }

    public void execute(String username, String password){
        SignupCompleteInputData signupCompleteInputData = new SignupCompleteInputData(
                username, password);

        signupUseCaseInteractor.execute(signupCompleteInputData);
    }

}

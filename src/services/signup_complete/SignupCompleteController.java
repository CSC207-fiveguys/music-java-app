package services.signup_complete;
public class SignupCompleteController {
    final SignupCompleteInputBoundary signupUseCaseInteractor;

    public SignupCompleteController(SignupCompleteInputBoundary signupUseCaseInteractor) {
        this.signupUseCaseInteractor = signupUseCaseInteractor;
    }

    public void execute(String username, String password1, String password2){
        SignupCompleteInputData signupCompleteInputData = new SignupCompleteInputData(
                username, password1, password2);

        signupUseCaseInteractor.execute(signupCompleteInputData);
    }

}

package services.signup_abort;

public class SignupAbortController {

    final SignupAbortInputBoundary signupAbortInteractor;

    public SignupAbortController(SignupAbortInputBoundary signupAbortInteractor) {
        this.signupAbortInteractor = signupAbortInteractor;
    }

    public void execute() {
        System.out.println("hello");
        signupAbortInteractor.execute();
    }
}

package services.signup_complete;

public interface SignupCompleteOutputBoundary {
    void prepareSuccessView(SignupCompleteOutputData user);

    void prepareFailView(String error);
}

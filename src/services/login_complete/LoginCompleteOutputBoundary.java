package services.login_complete;

public interface LoginCompleteOutputBoundary {
    void prepareSuccessView(LoginCompleteOutputData user);

    void prepareFailView(String error);
}

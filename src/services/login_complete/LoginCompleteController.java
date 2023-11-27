package services.login_complete;

public class LoginCompleteController {

    final LoginCompleteInputBoundary loginUseCaseInteractor;

    public LoginCompleteController(LoginCompleteInputBoundary loginUseCaseInteractor) {
        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }

    public void execute(String username, String password) {
        LoginCompleteInputData loginCompleteInputData = new LoginCompleteInputData(
                username, password);

        loginUseCaseInteractor.execute(loginCompleteInputData);
    }

}

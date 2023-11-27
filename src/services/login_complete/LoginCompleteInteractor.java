package services.login_complete;

import entities.User;

public class LoginCompleteInteractor implements LoginCompleteInputBoundary {

    final LoginCompleteUserDataAccessInterface userDataAccessObject;
    final LoginCompleteOutputBoundary loginCompletePresenter;

    public LoginCompleteInteractor(LoginCompleteOutputBoundary loginCompletePresenter,
                                   LoginCompleteUserDataAccessInterface userDataAccessObject) {
        this.userDataAccessObject = userDataAccessObject;
        this.loginCompletePresenter = loginCompletePresenter;
    }

    @Override
    public void execute(LoginCompleteInputData loginCompleteInputData) {
        String username = loginCompleteInputData.getUsername();
        String password = loginCompleteInputData.getPassword();

        if (!userDataAccessObject.exists(username)) {
            loginCompletePresenter.prepareFailView("Account does not exist for " + username + ".");
        } else {
            String pwd = userDataAccessObject.getUser(username).getPassword();
            if (!password.equals(pwd)) {
                loginCompletePresenter.prepareFailView("Incorrect password for " + username + ".");
            } else {

                User user = userDataAccessObject.getUser(loginCompleteInputData.getUsername());

                LoginCompleteOutputData loginCompleteOutputData = new LoginCompleteOutputData(
                        user.getUsername(),
                        false);
                loginCompletePresenter.prepareSuccessView(loginCompleteOutputData);
            }
        }
    }
}

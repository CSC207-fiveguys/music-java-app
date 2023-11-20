package services.signup_complete;

import data_access.UserDataAccessObject;
import entities.User;
import entities.UserFactory;

import java.util.Objects;

public class SignupCompleteInteractor implements SignupCompleteInputBoundary{
    final UserDataAccessObject userDataAccessObject;
    final SignupCompletePresenter signupCompletePresenter;

    public SignupCompleteInteractor(UserDataAccessObject userDataAccessObject,
                                    SignupCompletePresenter signupCompletePresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.signupCompletePresenter = signupCompletePresenter;
    }

    @Override
    public void execute(SignupCompleteInputData signupCompleteInputData) {
        String username = signupCompleteInputData.getUsername();
        String password1 = signupCompleteInputData.getPassword1();
        String password2 = signupCompleteInputData.getPassword2();

        if (userDataAccessObject.exists(username)){
            signupCompletePresenter.prepareFailView(username +
                    " is taken. Please choose a different username.");
        } else if (!Objects.equals(password1, password2)) {
            signupCompletePresenter.prepareFailView("Your passwords do not match. " +
                    "Please try again.");
        } else{
            UserFactory userFactory = new UserFactory();

            userDataAccessObject.saveUser(userFactory.create(username, password2));

            SignupCompleteOutputData signupCompleteOutputData = new SignupCompleteOutputData(username);

            signupCompletePresenter.prepareSuccessView(signupCompleteOutputData);
        }
    }
}

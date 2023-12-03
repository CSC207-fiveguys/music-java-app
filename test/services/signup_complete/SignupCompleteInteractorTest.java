package services.signup_complete;

import data_access.UserDataAccessObject;
import entities.User;
import entities.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SignupCompleteInteractorTest {

    private SignupCompleteInteractor interactor;
    private UserDataAccessObject userDataAccessObject;
    private SignupCompleteOutputBoundary outputBoundary;

    @BeforeEach
    void setUp() {
        UserFactory userFactory = new UserFactory();
        userDataAccessObject = new UserDataAccessObject(userFactory) {
            @Override
            public boolean exists(String username) {
                return "existingUser".equals(username);
            }

            @Override
            public void saveUser(User user) {
                // Implementation for saving a user
            }
        };

        outputBoundary = new SignupCompleteOutputBoundary() {
            @Override
            public void prepareSuccessView(SignupCompleteOutputData outputData) {
                assertNotNull(outputData, "Output data should not be null");
                assertEquals("newUser", outputData.getUsername(), "Username should match");
            }

            @Override
            public void prepareFailView(String error) {
                assertNotNull(error, "Error message should not be null");
            }
        };

        interactor = new SignupCompleteInteractor(userDataAccessObject, outputBoundary);
    }

    @Test
    void execute_SuccessfulSignup() {
        SignupCompleteInputData inputData = new SignupCompleteInputData("newUser", "password", "password");
        interactor.execute(inputData);
    }

    @Test
    void execute_FailedSignup_UsernameExists() {
        SignupCompleteInputData inputData = new SignupCompleteInputData("existingUser", "password", "password");
        interactor.execute(inputData);
    }

    @Test
    void execute_FailedSignup_PasswordMismatch() {
        SignupCompleteInputData inputData = new SignupCompleteInputData("newUser", "password1", "password2");
        interactor.execute(inputData);
    }
}

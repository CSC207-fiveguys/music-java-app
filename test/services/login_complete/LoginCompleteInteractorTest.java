package services.login_complete;

import data_access.UserDataAccessObject;
import entities.CommonUser;
import entities.User;
import entities.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoginCompleteInteractorTest {

    private LoginCompleteInteractor interactor;
    private LoginCompleteUserDataAccessInterface userDataAccessObject;
    private LoginCompleteOutputBoundary outputBoundary;

    @BeforeEach
    void setUp() {
        UserFactory userFactory = new UserFactory();
        userDataAccessObject = new UserDataAccessObject(userFactory) {
            @Override
            public boolean exists(String username) {
                return "existingUser".equals(username);
            }

            @Override
            public User getUser(String username) {
                if ("existingUser".equals(username)) {
                    return new CommonUser(username, "correctPassword");
                }
                return null;
            }
        };

        outputBoundary = new LoginCompleteOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginCompleteOutputData outputData) {
                assertNotNull(outputData, "Output data should not be null");
                assertEquals("existingUser", outputData.username, "Username should match");
            }

            @Override
            public void prepareFailView(String error) {
                assertNotNull(error, "Error message should not be null");
            }
        };

        interactor = new LoginCompleteInteractor(outputBoundary, userDataAccessObject);
    }

    @Test
    void successTest() {
        LoginCompleteInputData inputData = new LoginCompleteInputData("existingUser", "correctPassword");
        interactor.execute(inputData);
    }

    @Test
    void failureUserDoesNotExist() {
        LoginCompleteInputData inputData = new LoginCompleteInputData("nonExistingUser", "anyPassword");
        interactor.execute(inputData);
    }

    @Test
    void failureIncorrectPassword() {
        LoginCompleteInputData inputData = new LoginCompleteInputData("existingUser", "wrongPassword");
        interactor.execute(inputData);
    }
}

package services.login_new_signup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoginNewSignupInteractorTest {

    private LoginNewSignupInteractor interactor;
    private TestLoginNewSignupOutputBoundary outputBoundary;

    @BeforeEach
    void setUp() {
        outputBoundary = new TestLoginNewSignupOutputBoundary();
        interactor = new LoginNewSignupInteractor(outputBoundary);
    }

    @Test
    void execute_CallsPrepareSuccessView() {
        interactor.execute();
        assertTrue(outputBoundary.isPrepareSuccessViewCalled(), "prepareSuccessView should be called.");
    }

    static class TestLoginNewSignupOutputBoundary implements LoginNewSignupOutputBoundary {
        private boolean prepareSuccessViewCalled = false;

        @Override
        public void prepareSuccessView() {
            prepareSuccessViewCalled = true;
        }

        public boolean isPrepareSuccessViewCalled() {
            return prepareSuccessViewCalled;
        }
    }
}

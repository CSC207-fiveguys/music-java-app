package services.signup_abort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SignupAbortInteractorTest {

    private SignupAbortInteractor interactor;
    private TestSignupAbortOutputBoundary outputBoundary;

    @BeforeEach
    void setUp() {
        outputBoundary = new TestSignupAbortOutputBoundary();
        interactor = new SignupAbortInteractor(outputBoundary);
    }

    @Test
    void successTest() {
        interactor.execute();
        assertTrue(outputBoundary.isPrepareSuccessViewCalled(), "prepareSuccessView should be called.");
    }

    static class TestSignupAbortOutputBoundary implements SignupAbortOutputBoundary {
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

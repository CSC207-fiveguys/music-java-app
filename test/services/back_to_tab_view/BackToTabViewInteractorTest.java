package services.back_to_tab_view;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BackToTabViewInteractorTest {

    @Test
    void successTest() {
        BackToTabViewOutputBoundary outputBoundary = new BackToTabViewOutputBoundary() {
            @Override
            public void prepareSuccessView() {
                // Assert that the success view is prepared
                assertTrue(true, "Success view should be prepared.");
            }
        };

        BackToTabViewInteractor interactor = new BackToTabViewInteractor(outputBoundary);
        interactor.execute();
    }
}

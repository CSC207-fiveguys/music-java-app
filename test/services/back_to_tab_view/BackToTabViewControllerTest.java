package services.back_to_tab_view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BackToTabViewControllerTest {

    @Test
    void successTest() {
        BackToTabViewInputBoundary backToTabViewInputBoundary = new BackToTabViewInteractor(
            new BackToTabViewOutputBoundary() {
                @Override
                public void prepareSuccessView() {
                    assertTrue(true, "Success view should be  prepared");
                }
            });

        BackToTabViewController controller = new BackToTabViewController(backToTabViewInputBoundary);
        controller.execute();
    }
}
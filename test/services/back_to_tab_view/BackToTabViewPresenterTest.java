package services.back_to_tab_view;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.Test;
import view.ViewManagerModel;
import view.logged_in.TabViewModel;

class BackToTabViewPresenterTest {

    @Test
    void successTest() {
        TabViewModel tabViewModel = new TabViewModel("tab view");
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        BackToTabViewPresenter backToTabViewPresenter = new BackToTabViewPresenter(tabViewModel, viewManagerModel);
        backToTabViewPresenter.prepareSuccessView();
        assertEquals(viewManagerModel.activeView, tabViewModel.viewName);
    }

}
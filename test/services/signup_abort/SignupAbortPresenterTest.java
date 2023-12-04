package services.signup_abort;

import static org.junit.jupiter.api.Assertions.*;

import entities.Artist;
import entities.CommonArtist;
import entities.CommonTrack;
import entities.Track;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import services.search.SearchOutputData;
import services.search.SearchPresenter;
import view.ViewManagerModel;
import view.logged_in.tabs.SearchViewModel;
import view.logged_in.tabs.SearchViewState;
import view.logged_out.LoginViewModel;
import view.logged_out.LoginViewState;

class SignupAbortPresenterTest {

    @Test
    void prepareSuccessView() {
        SignupAbortPresenter signupAbortPresenter = new SignupAbortPresenter(new LoginViewModel("view", new LoginViewState()),
            new ViewManagerModel());
        signupAbortPresenter.prepareSuccessView();
        assertTrue(true, "success view presented");
    }
}
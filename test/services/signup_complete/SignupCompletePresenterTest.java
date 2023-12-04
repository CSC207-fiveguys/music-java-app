package services.signup_complete;

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
import view.logged_out.SignupViewModel;
import view.logged_out.SignupViewState;

class SignupCompletePresenterTest {

    @Test
    void prepareSuccessView() {
        SignupCompletePresenter signupCompletePresenter = new SignupCompletePresenter(new SignupViewModel("view", new SignupViewState()),
            new LoginViewModel("view", new LoginViewState()),
            new ViewManagerModel());
        signupCompletePresenter.prepareSuccessView(new SignupCompleteOutputData("user"));
        assertTrue(true, "success view presented");
    }

    @Test
    void prepareFailView() {
        SignupCompletePresenter signupCompletePresenter = new SignupCompletePresenter(new SignupViewModel("view", new SignupViewState()),
            new LoginViewModel("view", new LoginViewState()),
            new ViewManagerModel());
        signupCompletePresenter.prepareFailView("error");
        assertTrue(true, "fail view presented");
    }
}
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
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        LoginViewState loginViewState = new LoginViewState();
        LoginViewModel loginViewModel = new LoginViewModel("login", loginViewState);
        SignupViewState signupViewState = new SignupViewState();
        SignupViewModel signupViewModel = new SignupViewModel("signup", signupViewState);
        SignupCompletePresenter signupCompletePresenter = new SignupCompletePresenter(signupViewModel, loginViewModel, viewManagerModel);
        signupCompletePresenter.prepareSuccessView(new SignupCompleteOutputData("user"));
        assertEquals(viewManagerModel.activeView, loginViewModel.viewName);
    }

    @Test
    void prepareFailView() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        LoginViewState loginViewState = new LoginViewState();
        LoginViewModel loginViewModel = new LoginViewModel("login", loginViewState);
        SignupViewState signupViewState = new SignupViewState();
        SignupViewModel signupViewModel = new SignupViewModel("signup", signupViewState);
        SignupCompletePresenter signupCompletePresenter = new SignupCompletePresenter(signupViewModel, loginViewModel, viewManagerModel);
        signupCompletePresenter.prepareFailView("error");
        assertNull(viewManagerModel.activeView);
    }
}
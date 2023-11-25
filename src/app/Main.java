package app;

import data_access.UserDataAccessObject;
import entities.UserFactory;
import services.login_complete.*;
import services.login_new_signup.*;
import services.signup_abort.*;
import services.signup_complete.*;
import view.ViewManager;
import view.ViewManagerModel;
import view.logged_in.TabView;
import view.logged_in.TabViewModel;
import view.logged_out.*;

import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {

    public static void main(String[] args) {
        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel(cardLayout);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        ViewManager viewManager = new ViewManager(viewManagerModel, views, cardLayout);
        TabViewModel tabViewModel = new TabViewModel("tab view");
        JFrame frame = new JFrame("JFRAME TITLE");

        // Create a new DAO in Main that should be passed to the UseCaseFactories, to use for the Controller
        UserDataAccessObject userDataAccessObject = new UserDataAccessObject(new UserFactory());

        LoginViewState loginViewState = new LoginViewState();
        LoginViewModel loginViewModel = new LoginViewModel("log in view", loginViewState);

        SignupViewState signupViewState = new SignupViewState();
        SignupViewModel signupViewModel = new SignupViewModel("sign up view", signupViewState);

        LoginNewSignupOutputBoundary loginNewSignupPresenter = new LoginNewSignupPresenter(viewManagerModel, signupViewModel);
        LoginNewSignupInputBoundary loginNewSignupInteractor = new LoginNewSignupInteractor(loginNewSignupPresenter);
        LoginNewSignupController loginNewSignupController = new LoginNewSignupController(loginNewSignupInteractor);

        LoginCompleteOutputBoundary loginCompletePresenter = new LoginCompletePresenter(viewManagerModel, loginViewModel, tabViewModel);
        LoginCompleteInputBoundary loginCompleteInteractor = new LoginCompleteInteractor(loginCompletePresenter, userDataAccessObject);
        LoginCompleteController loginCompleteController = new LoginCompleteController(loginCompleteInteractor);

        LoginView loginView = new LoginView(loginViewModel, loginCompleteController, loginNewSignupController);
        views.add(loginView, loginViewModel.viewName);

        SignupAbortOutputBoundary abortSignupPresenter = new SignupAbortPresenter(loginViewModel, viewManagerModel);
        SignupAbortInputBoundary abortSignupInteractor = new SignupAbortInteractor(abortSignupPresenter);
        SignupAbortController signupAbortController = new SignupAbortController(abortSignupInteractor);

        SignupCompleteOutputBoundary signupCompletePresenter = new SignupCompletePresenter(signupViewModel, loginViewModel, viewManagerModel);
        SignupCompleteInputBoundary signupCompleteInteractor = new SignupCompleteInteractor(userDataAccessObject, signupCompletePresenter);
        SignupCompleteController signupCompleteController = new SignupCompleteController(signupCompleteInteractor);

        SignupView signupView = new SignupView(signupViewModel, signupCompleteController, signupAbortController);
        views.add(signupView, signupViewModel.viewName);

        TabView temp = new TabView(tabViewModel);
        temp.add(new JLabel("TESTTT MY LIBRARY VIEW"));
        temp.add(new JLabel("OK MY FLOOWERED ARTISIST VIEW"));
        temp.add(new JLabel("my  friends VIEW"));
        temp.add(new JLabel("SEARCHHHHHH VIEW"));
        views.add(temp, tabViewModel.viewName);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(views);
        frame.pack();
        frame.setVisible(true);
    }
}
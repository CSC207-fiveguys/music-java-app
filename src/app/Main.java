package app;

import data_access.UserDataAccessObject;
import entities.UserFactory;
import services.login_complete.LoginCompleteController;
import services.login_complete.LoginCompleteInteractor;
import services.login_complete.LoginCompletePresenter;
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
        LoginView loginView = new LoginView(loginViewModel, new LoginCompleteController
            (new LoginCompleteInteractor(userDataAccessObject,
                new LoginCompletePresenter(viewManagerModel, loginViewModel, tabViewModel))), null); //todo
        views.add(loginView, loginViewModel.viewName);


        SignupViewState signupViewState = new SignupViewState();
        SignupViewModel signupViewModel = new SignupViewModel("sign up view", signupViewState);
        SignupView signupView = new SignupView(signupViewModel, null, null); //todo
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

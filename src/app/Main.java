package app;

import data_access.UserDataAccessObject;
import entities.UserFactory;
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


        // Create a new DAO in MAIN that should be passed to the Views
        UserDataAccessObject UserDataAccessObject = new UserDataAccessObject(new UserFactory());
        LoginViewState loginViewState = new LoginViewState();
        LoginViewModel loginViewModel = new LoginViewModel("log in view", loginViewState);
        LoginView loginView = new LoginView(loginViewModel, null, null); //todo
        views.add(loginView, loginViewModel.viewName);


        SignupViewState signupViewState = new SignupViewState();
        SignupViewModel signupViewModel = new SignupViewModel("sign up view", signupViewState);
        SignupView signupView = new SignupView(signupViewModel, null, null); //todo
        views.add(signupView, signupViewModel.viewName);


        TabViewModel tabViewModel = new TabViewModel("tab view");
        TabView temp = new TabView(tabViewModel);
        temp.add(new JLabel("TESTTT MY LIBRARY VIEW"));
        temp.add(new JLabel("OK MY FLOOWERED ARTISIST VIEW"));
        temp.add(new JLabel("my  friends VIEW"));
        temp.add(new JLabel("SEARCHHHHHH VIEW"));
        views.add(temp, tabViewModel.viewName);


        JFrame frame = new JFrame("JFRAME TITLE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(views);
        frame.pack();
        frame.setVisible(true);
    }
}

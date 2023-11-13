package view.logged_out;

import services.login_complete.LoginCompleteController;
import services.login_new_signup.LoginNewSignupController;
import view.components.LabelTextPanel;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoginView extends JPanel implements PropertyChangeListener {

    private final LoginViewModel loginViewModel;
    private final LoginCompleteController loginCompleteController;
    private final LoginNewSignupController loginNewSignupController;
    private final JLabel currentError;
    private final JTextField usernameInputField;
    private final JPasswordField passwordInputField;
    private final JButton loginButton;
    private final JButton signupButton;

    public LoginView(LoginViewModel loginViewModel,
                     LoginCompleteController loginCompleteController,
                     LoginNewSignupController loginNewSignupController) {

        this.loginViewModel = loginViewModel;
        loginViewModel.addPropertyChangeListener(this);
        this.loginCompleteController = loginCompleteController;
        this.loginNewSignupController = loginNewSignupController;

        currentError = new JLabel(loginViewModel.state.currentError);
        add(currentError);

        usernameInputField = new JTextField(15);
        LabelTextPanel usernamePanel = new LabelTextPanel(new JLabel(loginViewModel.state.usernameInputFieldText), usernameInputField);
        add(usernamePanel);

        passwordInputField = new JPasswordField(15);
        LabelTextPanel passwordPanel = new LabelTextPanel(new JLabel(loginViewModel.state.passwordInputFieldText), passwordInputField);
        add(passwordPanel);

        loginButton = new JButton(loginViewModel.state.loginButtonText);
        add(loginButton);
        loginButton.addActionListener(e -> loginButtonPressed());

        signupButton = new JButton(loginViewModel.state.signupButtonText);
        add(signupButton);
        loginButton.addActionListener(e -> signupButtonPressed());
    }

    private void loginButtonPressed() {
        loginCompleteController.execute(loginViewModel.state.usernameInputFieldText,
            loginViewModel.state.passwordInputFieldText);
    }

    private void signupButtonPressed() {
//        loginNewSignupController.execute(); todo
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // handle property changes fired from signupViewModel
    }
}


package view.logged_out;

import java.awt.event.KeyEvent;
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

//<<<<<<< LoginComplete
    this.loginViewModel = loginViewModel;
    loginViewModel.addPropertyChangeListener(this);
    this.loginCompleteController = loginCompleteController;
    this.loginNewSignupController = loginNewSignupController;
//=======
    public LoginView(LoginViewModel loginViewModel,
        LoginCompleteController loginCompleteController,
        LoginNewSignupController loginNewSignupController) {
//>>>>>>> main

    currentError = new JLabel(loginViewModel.state.currentError);
    System.out.println(loginViewModel.state.currentError);
    add(currentError);

//<<<<<<< LoginComplete
    usernameInputField = new JTextField(15);
    LabelTextPanel usernamePanel = new LabelTextPanel(
        new JLabel(loginViewModel.state.usernameInputFieldText), usernameInputField);
    add(usernamePanel);

    passwordInputField = new JPasswordField(15);
    LabelTextPanel passwordPanel = new LabelTextPanel(
        new JLabel(loginViewModel.state.passwordInputFieldText), passwordInputField);
    add(passwordPanel);
//=======
        usernameInputField = new JTextField(15);
        LabelTextPanel usernamePanel = new LabelTextPanel(
            new JLabel(loginViewModel.state.usernameInputFieldText), usernameInputField);
        add(usernamePanel);

        passwordInputField = new JPasswordField(15);
        LabelTextPanel passwordPanel = new LabelTextPanel(
            new JLabel(loginViewModel.state.passwordInputFieldText), passwordInputField);
        add(passwordPanel);
//>>>>>>> main

    loginButton = new JButton(loginViewModel.state.loginButtonText);
    add(loginButton);
    loginButton.addActionListener(e -> loginButtonPressed());

//<<<<<<< LoginComplete
    signupButton = new JButton(loginViewModel.state.signupButtonText);
    add(signupButton);
    loginButton.addActionListener(e -> signupButtonPressed());
  }
//=======
        signupButton = new JButton(loginViewModel.state.signupButtonText);
        add(signupButton);
        signupButton.addActionListener(e -> signupButtonPressed());
    }
//>>>>>>> main

  private void loginButtonPressed() {
    loginCompleteController.execute(usernameInputField.getText(),
        passwordInputField.getText());
  }

//<<<<<<< LoginComplete
  private void signupButtonPressed() {
//        loginNewSignupController.execute(); todo
  }
//=======
    private void signupButtonPressed() {
        loginNewSignupController.execute();
    }
//>>>>>>> main

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    // handle property changes fired from signupViewModel
    // reassign all non-final values from state to view
    LoginViewState state = (LoginViewState) evt.getNewValue();
    currentError.setText(state.currentError);
  }
}


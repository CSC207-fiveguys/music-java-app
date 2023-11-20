package view.logged_out;

import services.signup.SignupCompleteController;
import services.signup_abort.SignupAbortController;
import view.components.LabelTextPanel;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SignupView extends JPanel implements PropertyChangeListener {

    private final SignupViewModel signupViewModel;
    private final SignupCompleteController signupCompleteController;
    private final SignupAbortController signupAbortController;

    private final JTextField usernameInputField;
    private final JPasswordField password1InputField;
    private final JPasswordField password2InputField;
    private final JButton signupButton;
    private final JButton cancelButton;

    public SignupView(SignupViewModel signupViewModel,
        SignupCompleteController signupCompleteController,
        SignupAbortController signupAbortController) {
        this.signupViewModel = signupViewModel;
        signupViewModel.addPropertyChangeListener(this);
        this.signupCompleteController = signupCompleteController;
        this.signupAbortController = signupAbortController;

        usernameInputField = new JTextField(15);
        LabelTextPanel usernamePanel = new LabelTextPanel(
            new JLabel(signupViewModel.state.usernameInputFieldText), usernameInputField);
        add(usernamePanel);

        password1InputField = new JPasswordField(15);
        LabelTextPanel password1Panel = new LabelTextPanel(
            new JLabel(signupViewModel.state.password1InputFieldText), password1InputField);
        add(password1Panel);

        password2InputField = new JPasswordField(15);
        LabelTextPanel password2Panel = new LabelTextPanel(
            new JLabel(signupViewModel.state.password2InputFieldText), password2InputField);
        add(password2Panel);

        signupButton = new JButton(signupViewModel.state.signupButtonText);
        add(signupButton);
        signupButton.addActionListener(e -> signupButtonPressed());

        cancelButton = new JButton(signupViewModel.state.cancelButtonText);
        add(cancelButton);
        cancelButton.addActionListener(e -> cancelButtonPressed());
    }

    private void signupButtonPressed() {
        // signupCompleteController.execute(); todo
    }

    private void cancelButtonPressed() {
        signupAbortController.execute();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // handle property changes fired from signupViewModel
    }
}

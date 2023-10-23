package view.logged_out;

import view.components.LabelTextPanel;

import javax.swing.*;
import java.awt.*;

public class SignupView extends JPanel {

    private final JTextField usernameInputField;
    private final JPasswordField passwordInputField;
    private final JButton signupButton;

    private final CardLayout x; // TODO TEMPPPPP DELETE THIS HSOULD BE HANDELED BY VIEWMANAGER
    private final JPanel x_parent; //TODO TEMP DELETE ^^^

    public SignupView(CardLayout x, JPanel x_parent) {
        this.x = x; // TODO DELETE
        this.x_parent = x_parent; //TODO DELETE

        usernameInputField = new JTextField(15);
        LabelTextPanel usernamePanel = new LabelTextPanel(new JLabel("okok username"), usernameInputField);
        add(usernamePanel);

        passwordInputField = new JPasswordField(15);
        LabelTextPanel passwordPanel = new LabelTextPanel(new JLabel("PASSword"), passwordInputField);
        add(passwordPanel);

        signupButton = new JButton("sign me up my g");
        add(signupButton);
        signupButton.addActionListener(e -> signupButtonPressed());
    }

    private void signupButtonPressed() {
        System.out.println(usernameInputField);
        System.out.println(passwordInputField);
        x.next(x_parent);
    }
}

package view.components.row_components;

import javax.swing.*;
import java.awt.*;

public class UsernameRowPanel extends HeaderRowPanel {

    public final JLabel label;

    public UsernameRowPanel(String username) {
        this.label = new JLabel();
        updateUsername(username);
        add(label);

        setBackground(Color.GRAY);
    }

    public void updateUsername(String username) {
        label.setText("Welcome, " + username);
    }
}

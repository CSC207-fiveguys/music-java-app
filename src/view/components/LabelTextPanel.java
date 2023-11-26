package view.components;

import javax.swing.*;

public class LabelTextPanel extends JPanel {
    public LabelTextPanel(JLabel label, JTextField textField) {
        add(label);
        add(textField);
    }
}

package view.components.row_components;

import javax.swing.*;
import java.awt.*;

public abstract class HeaderRowPanel extends JPanel {
    public HeaderRowPanel() {
        setMinimumSize(new Dimension(1312, 32));
        setPreferredSize(new Dimension(1312, 32));
        setMaximumSize(new Dimension(1312, 32));
    }
}

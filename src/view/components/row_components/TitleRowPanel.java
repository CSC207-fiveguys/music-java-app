package view.components.row_components;

import javax.swing.*;
import java.awt.*;

public class TitleRowPanel extends HeaderRowPanel {

    public TitleRowPanel(String viewName) {
        add(new JLabel("You are in \"" + viewName + "\""));

        setBackground(Color.LIGHT_GRAY);
    }

}

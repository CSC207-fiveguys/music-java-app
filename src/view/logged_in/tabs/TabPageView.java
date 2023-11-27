package view.logged_in.tabs;

import view.components.row_components.TitleRowPanel;
import view.components.row_components.UsernameRowPanel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;

public abstract class TabPageView extends JPanel implements PropertyChangeListener {

    public final JPanel innerPanel;
    public final UsernameRowPanel usernameHeaderRowPanel;

    public TabPageView(String username, String viewName) {
        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
        this.innerPanel = innerPanel;

        JScrollPane scrollPane = new JScrollPane(innerPanel);
        scrollPane.setMinimumSize(new Dimension(1312, 256));
        scrollPane.setPreferredSize(new Dimension(1312, 256));
        scrollPane.setMaximumSize(new Dimension(1312, 256));

        JPanel outerPanel = new JPanel();
        outerPanel.setLayout(new BoxLayout(outerPanel, BoxLayout.Y_AXIS));

        this.usernameHeaderRowPanel = new UsernameRowPanel(username);
        outerPanel.add(usernameHeaderRowPanel);
        outerPanel.add(new TitleRowPanel(viewName));
        outerPanel.add(scrollPane);
        add(outerPanel);
    }

}

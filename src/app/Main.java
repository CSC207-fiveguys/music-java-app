package app;

import view.logged_out.SignupView;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;

public class Main extends JPanel {

    public static void main(String[] args) {
        createAndShowGUI();
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("JFRAME TITLE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = createCardJPanel();
        frame.add(panel);

        frame.pack();
        frame.setVisible(true);
    }

    public static JPanel createCardJPanel() {
        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel(cardLayout);

        views.add(new SignupView(cardLayout, views));
//        views.add(loginView);
        views.add(createLoggedInViewWrapper());

        return views;
    }

    public static JTabbedPane createLoggedInViewWrapper() {

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Tab 1", null, new JLabel("TESTTT MY LIBRARY VIEW"), "tooltip 1");
        tabbedPane.addTab("Tab 2", null, new JLabel("OK MY FLOOWERED ARTISIST VIEW"), "tooltip 2");
        tabbedPane.addTab("Tab 3", null, new JLabel("my  friends VIEW"), "tooltip3");
        tabbedPane.addTab("Tab 4", null, new JLabel("SEARCHHHHHH VIEW"), "tooltip4");

        return tabbedPane;
    }
}

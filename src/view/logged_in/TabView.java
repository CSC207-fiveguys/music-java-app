package view.logged_in;

import javax.swing.*;

public class TabView extends JTabbedPane {

    private final TabViewModel tabViewModel;

    public TabView(TabViewModel tabViewModel) {
        this.tabViewModel = tabViewModel;
    }
}

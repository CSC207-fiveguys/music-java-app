package view;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ViewManager implements PropertyChangeListener {

    private final CardLayout cardLayout;
    private final JPanel views;

    public ViewManager(ViewManagerModel viewManagerModel, JPanel views, CardLayout cardLayout) {
        this.cardLayout = cardLayout;
        this.views = views;

        // subscribe/listen to ViewManagerModel
        viewManagerModel.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("view")) {
            String viewModelName = (String) evt.getNewValue();

            System.out.println(viewModelName);

            cardLayout.show(views, viewModelName);

        }
    }
}

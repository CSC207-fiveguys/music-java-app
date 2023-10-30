package view.logged_in;

import view.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TabViewModel extends ViewModel {

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public TabViewModel(String viewName) {
        super(viewName);
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, "never used lol"); //TODO
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}

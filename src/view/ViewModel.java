package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class ViewModel {

    public final String viewName;
    protected final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public ViewModel(String viewName) {
        this.viewName = viewName;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public abstract void firePropertyChanged();

}
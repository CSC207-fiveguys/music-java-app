package view;

import java.beans.PropertyChangeListener;

public abstract class ViewModel {

    public final String viewName;

    public ViewModel(String viewName) {
        this.viewName = viewName;
    }

    public abstract void firePropertyChanged();

    public abstract void addPropertyChangeListener(PropertyChangeListener listener);
}
package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class ViewManagerModel {

    // does not extend ViewModel since does not need a viewName

    // viewNames are used by ViewManager for switching views

    public String activeView;
    // should be one of
    // SignupViewModel.viewName
    // LoginViewModel.viewName
    // TabViewModel.viewName
    // PlaylistViewModel.viewName

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // alert ViewManager to update the view
    public void firePropertyChanged() {
        support.firePropertyChange("view", null, this.activeView);
    }

    // lets ViewManager subscribe/listen to ViewManagerModel
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
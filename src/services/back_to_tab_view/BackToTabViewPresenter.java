package services.back_to_tab_view;

import view.ViewManagerModel;
import view.logged_in.TabViewModel;

public class BackToTabViewPresenter implements BackToTabViewOutputBoundary{

  private final TabViewModel tabViewModel;
  private final ViewManagerModel viewManagerModel;

  public BackToTabViewPresenter(TabViewModel tabViewModel, ViewManagerModel viewManagerModel) {
    this.tabViewModel = tabViewModel;
    this.viewManagerModel = viewManagerModel;
  }

  @Override
  public void prepareSuccessView() {
    viewManagerModel.activeView = tabViewModel.viewName;
    viewManagerModel.firePropertyChanged();
  }
}

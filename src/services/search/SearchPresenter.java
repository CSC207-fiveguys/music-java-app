package services.search;

import view.ViewManagerModel;
import view.logged_in.TabViewModel;

public class SearchPresenter implements SearchOutputBoundary{

  private final TabViewModel tabViewModel;

  private final ViewManagerModel viewManagerModel;

  public SearchPresenter(TabViewModel tabViewModel, ViewManagerModel viewManagerModel){
    this.tabViewModel = tabViewModel;
    this.viewManagerModel = viewManagerModel;
  }
  @Override
  public void prepareSuccessView(SearchOutputData searchOutputData) {
    // Output Stuff

  }
}

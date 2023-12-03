package services.back_to_tab_view;

public class BackToTabViewInteractor implements BackToTabViewInputBoundary {

  private final BackToTabViewOutputBoundary backToTabViewOutputBoundary;

  public BackToTabViewInteractor(BackToTabViewOutputBoundary backToTabViewOutputBoundary) {
    this.backToTabViewOutputBoundary = backToTabViewOutputBoundary;
  }

  @Override
  public void execute() {
    backToTabViewOutputBoundary.prepareSuccessView();
  }
}

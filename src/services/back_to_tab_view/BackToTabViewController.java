package services.back_to_tab_view;

public class BackToTabViewController {

    private final BackToTabViewInputBoundary backToTabViewInteractor;

    public BackToTabViewController(BackToTabViewInputBoundary backToTabViewInteractor) {
        this.backToTabViewInteractor = backToTabViewInteractor;
    }

    public void execute() {
        backToTabViewInteractor.execute();
    }
}

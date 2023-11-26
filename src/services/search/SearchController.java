package services.search;

public class SearchController {

    final SearchInputBoundary searchInteractor;

    public SearchController(SearchInputBoundary searchInteractor){
        this.searchInteractor = searchInteractor;
    }
    public void execute(String searchQuery) {
        // todo1. update SearchViewModel with up to 5 tracks, artists, and friends
    }
}

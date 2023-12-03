package services.search;

public class SearchController {

    final SearchInputBoundary searchInteractor;

    public SearchController(SearchInputBoundary searchInteractor){
        this.searchInteractor = searchInteractor;
    }
    public void execute(String searchQuery, SearchAlgorithm searchAlgorithm) {
        SearchInputData searchInputData = new SearchInputData(searchQuery, searchAlgorithm);
        searchInteractor.execute(searchInputData);
    }

}

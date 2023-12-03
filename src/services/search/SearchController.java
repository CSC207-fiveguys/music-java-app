package services.search;

public class SearchController {

    final SearchInputBoundary searchInteractor;
    final SearchAlgorithm searchAlgorithm;

    public SearchController(SearchInputBoundary searchInteractor, SearchAlgorithm searchAlgorithm){
        this.searchInteractor = searchInteractor;
        this.searchAlgorithm = searchAlgorithm;
    }
    public void execute(String searchQuery) {
        SearchInputData searchInputData = new SearchInputData(searchQuery, searchAlgorithm);
        searchInteractor.execute(searchInputData);
    }

}

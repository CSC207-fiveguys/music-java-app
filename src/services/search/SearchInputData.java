package services.search;

public class SearchInputData {

    public final String searchQuery;
    public final SearchAlgorithm searchAlgorithm;

    public SearchInputData(String searchQuery, SearchAlgorithm searchAlgorithm) {
        this.searchQuery = searchQuery;
        this.searchAlgorithm = searchAlgorithm;
    }

}

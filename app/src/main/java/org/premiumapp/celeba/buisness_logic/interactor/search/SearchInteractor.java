package org.premiumapp.celeba.buisness_logic.interactor.search;

import org.premiumapp.celeba.buisness_logic.search_engine.SearchEngine;

import io.reactivex.Observable;

/**
 * Created by a on 12.07.17.
 */

public class SearchInteractor {

    private final SearchEngine searchEngine;

    public SearchInteractor(SearchEngine searchEngine) {
        this.searchEngine = searchEngine;
    }

    public Observable<SearchViewState> search(String query) {

        if (query.isEmpty()) {
            return Observable.just(new SearchViewState.SearchNotStartedYet());
        }

        return searchEngine.searchFor(query)
                .map(people -> {
                    if (people.isEmpty()) {
                        return new SearchViewState.EmptyResult(query);
                    } else {
                        return new SearchViewState.SearchResult(query, people);
                    }
                })
                .startWith(new SearchViewState.Loading())
                .onErrorReturn(er -> new SearchViewState.Error(query, er));
    }
}

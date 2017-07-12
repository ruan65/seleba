package org.premiumapp.celeba.buisness_logic.interactor.search;

import org.premiumapp.celeba.buisness_logic.model.TmdbPerson;

import java.util.List;

/**
 * Created by a on 07.07.17.
 */

public interface SearchViewState {

    final class SearchNotStartedYet implements SearchViewState {
    }

    final class Loading implements SearchViewState {
    }

    final class EmptyResult implements SearchViewState {

        private final String searchQuery;

        public EmptyResult(String searchQuery) {
            this.searchQuery = searchQuery;
        }

        public String getSearchQuery() {
            return searchQuery;
        }
    }

    final class SearchResult implements SearchViewState {

        private final String searchQuery;
        private final List<TmdbPerson> result;

        public SearchResult(String searchQuery, List<TmdbPerson> result) {
            this.searchQuery = searchQuery;
            this.result = result;
        }

        public String getSearchQuery() {
            return searchQuery;
        }

        public List<TmdbPerson> getResult() {
            return result;
        }
    }

    final class Error implements SearchViewState {

        private final String searchQuery;
        private final Throwable error;

        public Error(String searchQuery, Throwable error) {
            this.searchQuery = searchQuery;
            this.error = error;
        }

        public String getSearchQuery() {
            return searchQuery;
        }

        public Throwable getError() {
            return error;
        }
    }
}

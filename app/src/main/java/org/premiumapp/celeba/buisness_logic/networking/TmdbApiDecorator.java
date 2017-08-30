package org.premiumapp.celeba.buisness_logic.networking;

import org.premiumapp.celeba.buisness_logic.networking.response_objects.SearchPersonResponse;

import io.reactivex.Observable;

/**
 * Created by a on 12.07.17.
 */

public class TmdbApiDecorator {

    private final TmdbApi api;

    public TmdbApiDecorator(TmdbApi api) {
        this.api = api;
    }

    public Observable<SearchPersonResponse> getPersonSearchResult(String query) {
        return api.searchPearson(query);
    }
//
//    public Observable<List<TmdbPerson>> getPersonSearchResult(String query, String page) {
//        return api.searchPearson(query);
//    }
}

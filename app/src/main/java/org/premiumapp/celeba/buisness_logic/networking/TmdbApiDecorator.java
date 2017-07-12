package org.premiumapp.celeba.buisness_logic.networking;

import org.premiumapp.celeba.buisness_logic.model.TmdbPerson;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by a on 12.07.17.
 */

public class TmdbApiDecorator {

    private final TmdbApi api;

    public TmdbApiDecorator(TmdbApi api) {
        this.api = api;
    }

    public Observable<List<TmdbPerson>> getPersonSearchResult(String query) {
        return api.searchPearson(query, "0");
    }

    public Observable<List<TmdbPerson>> getPersonSearchResult(String query, String page) {
        return api.searchPearson(query, page);
    }
}

package org.premiumapp.celeba.buisness_logic.search_engine;

import android.support.annotation.NonNull;

import org.premiumapp.celeba.buisness_logic.model.TmdbPerson;
import org.premiumapp.celeba.buisness_logic.networking.TmdbApiDecorator;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

/**
 * Created by a on 12.07.17.
 */

public class SearchEngine {

    private final TmdbApiDecorator backend;

    public SearchEngine(TmdbApiDecorator backend) {
        this.backend = backend;
    }

    public Observable<List<TmdbPerson>> searchFor(@NonNull String query) {

        if (query.length() < 3) {
            return Observable.error(new IllegalArgumentException("Search query should be > 3 chars"));
        }

        return backend.getPersonSearchResult(query)
                .delay(200, TimeUnit.MICROSECONDS)
                .flatMap(result -> Observable.fromIterable(result))
                .toList()
                .toObservable();
    }
}

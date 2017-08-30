package org.premiumapp.celeba.dependencyinjection;

import org.premiumapp.celeba.buisness_logic.interactor.search.SearchInteractor;
import org.premiumapp.celeba.buisness_logic.networking.TmdbApi;
import org.premiumapp.celeba.buisness_logic.networking.TmdbApiDecorator;
import org.premiumapp.celeba.buisness_logic.search_engine.SearchEngine;
import org.premiumapp.celeba.utils.Cv;
import org.premiumapp.celeba.view.search.SearchPresenter;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by a on 14.08.17.
 */

public class DependencyInjection {

    private final Retrofit retrofit = createRetrofitClient();

    private Retrofit createRetrofitClient() {

        HttpLoggingInterceptor httpLogger = new HttpLoggingInterceptor();
        httpLogger.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(httpLogger).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Cv.Urls.TMDB_3)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        return retrofit;
    }

    private final TmdbApi tmdbApi = retrofit.create(TmdbApi.class);

    private final TmdbApiDecorator tmdbApiDecorator = new TmdbApiDecorator(tmdbApi);

    private SearchEngine newSearchEngine() {
        return new SearchEngine(tmdbApiDecorator);
    }

    private SearchInteractor newSearchInteractor() {
        return new SearchInteractor(newSearchEngine());
    }

    public SearchPresenter newSearchPresenter() {
        return new SearchPresenter(newSearchInteractor());
    }

}

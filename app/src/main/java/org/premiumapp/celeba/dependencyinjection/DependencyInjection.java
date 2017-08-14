package org.premiumapp.celeba.dependencyinjection;

import org.premiumapp.celeba.buisness_logic.networking.TmdbApi;
import org.premiumapp.celeba.utils.Cv;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by a on 14.08.17.
 */

public class DependencyInjection {

    private final HttpLoggingInterceptor httpLogger = new HttpLoggingInterceptor();
    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Cv.Urls.TMDB_3)
            .client(new OkHttpClient.Builder().addInterceptor(httpLogger).build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build();

    private final TmdbApi tmdbApi = retrofit.create(TmdbApi.class);


}

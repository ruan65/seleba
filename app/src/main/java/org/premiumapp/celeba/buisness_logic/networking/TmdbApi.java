package org.premiumapp.celeba.buisness_logic.networking;

import org.premiumapp.celeba.buisness_logic.model.TmdbPerson;
import org.premiumapp.celeba.utils.Cv;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by a on 12.07.17.
 */

public interface TmdbApi {

    @GET(Cv.Urls.TMDB_3 + "/search/person?api_key=" + Cv.Urls.API_KEY)
    Observable<List<TmdbPerson>> searchPearson(
            @Query("query") String query,
            @Query("page") String page);

}

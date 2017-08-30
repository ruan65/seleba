package org.premiumapp.celeba.buisness_logic.networking;

import org.premiumapp.celeba.buisness_logic.networking.response_objects.SearchPersonResponse;
import org.premiumapp.celeba.utils.Cv;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by a on 12.07.17.
 */

public interface TmdbApi {

    @GET(Cv.Urls.TMDB_3 + "search/person?api_key=" + Cv.Urls.API_KEY)
    Observable<SearchPersonResponse> searchPearson(
            @Query("query") String query);

}

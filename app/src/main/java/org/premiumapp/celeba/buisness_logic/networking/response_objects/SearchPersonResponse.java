package org.premiumapp.celeba.buisness_logic.networking.response_objects;

import org.premiumapp.celeba.buisness_logic.model.TmdbPerson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 8/30/17.
 */

public class SearchPersonResponse {

    public int page, total_pages, total_results;

    public List<TmdbPerson> results = new ArrayList<>();
}

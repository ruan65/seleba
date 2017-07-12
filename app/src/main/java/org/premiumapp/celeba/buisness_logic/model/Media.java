package org.premiumapp.celeba.buisness_logic.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 12.07.17.
 */

public class Media {

    public float vote_average, popularity;

    public int vote_count, id;

    public boolean video, adult;

    public String media_type, title, poster_path, original_language, original_title,
            backdrop_path, overview, release_date;

    public List<Integer> genre_ids = new ArrayList<>();

    @Override
    public String toString() {
        return "Media{" +
                "vote_average=" + vote_average +
                ", popularity=" + popularity +
                ", vote_count=" + vote_count +
                ", id=" + id +
                ", video=" + video +
                ", adult=" + adult +
                ", media_type='" + media_type + '\'' +
                ", title='" + title + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", original_language='" + original_language + '\'' +
                ", original_title='" + original_title + '\'' +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", overview='" + overview + '\'' +
                ", release_date='" + release_date + '\'' +
                ", genre_ids=" + genre_ids +
                '}';
    }
}

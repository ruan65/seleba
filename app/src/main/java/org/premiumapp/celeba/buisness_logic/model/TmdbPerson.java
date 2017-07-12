package org.premiumapp.celeba.buisness_logic.model;

import java.util.List;

/**
 * Created by a on 07.07.17.
 */

public class TmdbPerson {

    public int id;
    public String name, profile_path;
    public float pupularity;
    public boolean adult;

    public List<Media> known_for;

    @Override
    public String toString() {
        return "TmdbPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profile_path='" + profile_path + '\'' +
                ", pupularity=" + pupularity +
                ", adult=" + adult +
                ", known_for=" + known_for +
                '}';
    }
}

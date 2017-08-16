package org.premiumapp.celeba.view.search;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.premiumapp.celeba.buisness_logic.model.TmdbPerson;
import org.premiumapp.celeba.view.ui.viewholder.PersonViewHolder;

import java.util.List;

/**
 * Created by a on 15.08.17.
 */

public class SearchAdapter extends RecyclerView.Adapter<PersonViewHolder> {

    private final LayoutInflater inflater;
    private final PersonViewHolder.PersonClickedListener personClickedListener;
    private List<TmdbPerson> persons;

    public SearchAdapter(LayoutInflater inflater, PersonViewHolder.PersonClickedListener personClickedListener) {
        this.inflater = inflater;
        this.personClickedListener = personClickedListener;
    }

    public void setPersons(List<TmdbPerson> persons) {
        this.persons = persons;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return PersonViewHolder.create(inflater, personClickedListener);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        holder.bind(persons.get(position));
    }

    @Override
    public int getItemCount() {
        return null == persons ? 0 : persons.size();
    }
}

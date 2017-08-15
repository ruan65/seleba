package org.premiumapp.celeba.view.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.premiumapp.celeba.buisness_logic.model.TmdbPerson;

import butterknife.ButterKnife;

/**
 * Created by a on 15.08.17.
 */

public class PersonViewHolder extends RecyclerView.ViewHolder {

    private TmdbPerson person;

    public interface PersonClickedListener {
        void onProductClicked(TmdbPerson person);
    }

    public PersonViewHolder(View itemView, PersonClickedListener clickedListener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(v -> clickedListener.onProductClicked());
    }
}

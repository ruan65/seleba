package org.premiumapp.celeba.view.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.premiumapp.celeba.R;
import org.premiumapp.celeba.buisness_logic.model.TmdbPerson;
import org.premiumapp.celeba.utils.Cv;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by a on 15.08.17.
 */

public class PersonViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.personImage) ImageView image;
    @BindView(R.id.personName) TextView name;

    private TmdbPerson person;

    public interface PersonClickedListener {
        void onPersonClicked(TmdbPerson person);
    }

    public static PersonViewHolder create(LayoutInflater inflater, PersonClickedListener listener) {
        return new PersonViewHolder(inflater.inflate(R.layout.item_person_search, null, false), listener);
    }

    public PersonViewHolder(View itemView, PersonClickedListener clickedListener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(v -> clickedListener.onPersonClicked(person));
    }

    public void bind(TmdbPerson person) {
        this.person = person;
        Glide.with(itemView.getContext())
                .load(Cv.Urls.TMDB_3 + person.profile_path)
                .centerCrop()
                .into(image);


    }
}

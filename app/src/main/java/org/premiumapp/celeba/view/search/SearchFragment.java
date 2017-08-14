package org.premiumapp.celeba.view.search;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby3.mvi.MviFragment;

import org.premiumapp.celeba.R;
import org.premiumapp.celeba.buisness_logic.interactor.search.SearchInteractor;
import org.premiumapp.celeba.buisness_logic.networking.TmdbApiDecorator;
import org.premiumapp.celeba.buisness_logic.search_engine.SearchEngine;

/**
 * A simple {@link Fragment} subclass.
 */
//public class SearchFragment extends MviFragment<SearchView, SearchPresenter> {
public class SearchFragment extends Fragment {


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

}

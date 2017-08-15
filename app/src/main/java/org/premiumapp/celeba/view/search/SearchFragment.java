package org.premiumapp.celeba.view.search;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.mosby3.mvi.MviFragment;
import com.jakewharton.rxbinding2.widget.RxSearchView;

import org.premiumapp.celeba.R;
import org.premiumapp.celeba.ThisApp;
import org.premiumapp.celeba.buisness_logic.interactor.search.SearchViewState;

import java.util.concurrent.TimeUnit;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observable;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends MviFragment<SearchView, SearchPresenter>
        implements SearchView {

    @BindView(R.id.searchView) android.widget.SearchView searchView;
    @BindView(R.id.container) ViewGroup container;
    @BindView(R.id.loadingView) View loadingView;
    @BindView(R.id.errorView) TextView errorView;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.emptyView) View emptyView;
    @BindInt(R.integer.grid_span_size) int spanCount;

    private Unbinder unbinder;

    public SearchFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public SearchPresenter createPresenter() {
        return ThisApp.getDependencyInjection(getActivity()).newSearchPresenter();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public Observable<String> searchIntent() {
        return RxSearchView.queryTextChanges(searchView)
                .skip(2)
                .filter(queryString -> queryString.length() > 3 || queryString.length() == 0)
                .debounce(500, TimeUnit.MILLISECONDS)
                .distinctUntilChanged()
                .map(CharSequence::toString)
                ;
    }

    @Override
    public void render(SearchViewState viewState) {

    }
}

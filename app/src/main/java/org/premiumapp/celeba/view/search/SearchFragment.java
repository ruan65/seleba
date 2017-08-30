package org.premiumapp.celeba.view.search;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.transition.TransitionManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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
import org.premiumapp.celeba.buisness_logic.model.TmdbPerson;
import org.premiumapp.celeba.view.MainActivity;
import org.premiumapp.celeba.view.ui.GridSpacingItemDecoration;
import org.premiumapp.celeba.view.ui.viewholder.PersonViewHolder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observable;
import timber.log.Timber;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends MviFragment<SearchView, SearchPresenter>
        implements SearchView, PersonViewHolder.PersonClickedListener {

    @BindView(R.id.searchView) android.widget.SearchView searchView;
    @BindView(R.id.container) ViewGroup container;
    @BindView(R.id.loadingView) View loadingView;
    @BindView(R.id.errorView) TextView errorView;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.emptyView) View emptyView;
    @BindInt(R.integer.grid_span_size) int spanCount;

    private Unbinder unbinder;

    private SearchAdapter searchAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);
        unbinder = ButterKnife.bind(this, view);

        searchAdapter = new SearchAdapter(inflater, this);
        recyclerView.setAdapter(searchAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), spanCount));
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, 16, true));

        return view;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        ((MainActivity) getActivity()).showVidgets();
        super.onDetach();
    }

    @NonNull
    @Override
    public SearchPresenter createPresenter() {
        return ThisApp.getDependencyInjection(getActivity()).newSearchPresenter();
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

        Timber.d("render %s", viewState);

        if (viewState instanceof SearchViewState.SearchNotStartedYet) {

            renderSearchNotStarted();

        } else if (viewState instanceof SearchViewState.Loading) {

            renderLoading();

        } else if (viewState instanceof SearchViewState.SearchResult) {

            renderResult(((SearchViewState.SearchResult) viewState).getResult());

        } else if (viewState instanceof SearchViewState.EmptyResult) {

            renderEmptyResult();

        } else if (viewState instanceof SearchViewState.Error) {

            Timber.e(((SearchViewState.Error) viewState).getError());
            renderError();

        } else {
            throw new IllegalArgumentException("Don't know how to render viewState " + viewState);
        }
    }

    @Override
    public void onPersonClicked(TmdbPerson person) {

    }

    private void renderSearchNotStarted() {
        TransitionManager.beginDelayedTransition(container);
        recyclerView.setVisibility(View.GONE);
        loadingView.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
        emptyView.setVisibility(View.GONE);
    }

    private void renderLoading() {
        TransitionManager.beginDelayedTransition(container);
        recyclerView.setVisibility(View.GONE);
        loadingView.setVisibility(View.VISIBLE);
        errorView.setVisibility(View.GONE);
        emptyView.setVisibility(View.GONE);
    }

    private void renderError() {
        TransitionManager.beginDelayedTransition(container);
        recyclerView.setVisibility(View.GONE);
        loadingView.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
    }

    private void renderEmptyResult() {
        TransitionManager.beginDelayedTransition(container);
        recyclerView.setVisibility(View.GONE);
        loadingView.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
        emptyView.setVisibility(View.VISIBLE);
    }

    private void renderResult(List<TmdbPerson> result) {
        TransitionManager.beginDelayedTransition(container);
        recyclerView.setVisibility(View.VISIBLE);
        loadingView.setVisibility(View.GONE);
        emptyView.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
        searchAdapter.setPersons(result);
        searchAdapter.notifyDataSetChanged();
    }
}

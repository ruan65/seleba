package org.premiumapp.celeba.view.search;

import com.hannesdorfmann.mosby3.mvp.MvpView;

import org.premiumapp.celeba.buisness_logic.interactor.search.SearchViewState;

import io.reactivex.Observable;

/**
 * Created by a on 12.07.17.
 */

public interface SearchView extends MvpView {

    Observable<String> searchIntent();

    void render(SearchViewState viewState);
}

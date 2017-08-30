package org.premiumapp.celeba.view.search;

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter;

import org.premiumapp.celeba.buisness_logic.interactor.search.SearchInteractor;
import org.premiumapp.celeba.buisness_logic.interactor.search.SearchViewState;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import timber.log.Timber;

/**
 * Created by a on 13.07.17.
 */

public class SearchPresenter extends MviBasePresenter<SearchView, SearchViewState> {

    private final SearchInteractor searchInteractor;

    public SearchPresenter(SearchInteractor searchInteractor) {
        super(new SearchViewState.SearchNotStartedYet());
        this.searchInteractor = searchInteractor;
    }


    @Override
    protected void bindIntents() {

        Observable<SearchViewState> search =
                intent(SearchView::searchIntent)
                        .doOnNext(s -> Timber.d("intent: Search '%s'", s))
                        .switchMap(searchInteractor::search)
                        .observeOn(AndroidSchedulers.mainThread());

        subscribeViewState(search, SearchView::render);
    }
}

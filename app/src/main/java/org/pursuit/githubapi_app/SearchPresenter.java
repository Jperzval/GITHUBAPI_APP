package org.pursuit.githubapi_app;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SearchPresenter implements Contract.ItemPresenter {

    private final Contract.SearchItemsView searchItemsView;
    private final GithubApi githubApi;

    public SearchPresenter(Contract.SearchItemsView searchItemsView, GithubApi githubApi) {
        this.searchItemsView = searchItemsView;
        this.githubApi = githubApi;
    }

    @SuppressLint("CheckResult")
    @Override
    public void getItemCall(String input) {
        GHRetrofit.getRetrofitInstance()
                .create(GithubApi.class)
                .getItemResponse(input)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((ItemResponse response) -> {
                            List<Item> itemList = new ArrayList<>(response.getItemResponse());
                            searchItemsView.showItems(itemList);
                        },
                        throwable -> searchItemsView.showError());
    }
}

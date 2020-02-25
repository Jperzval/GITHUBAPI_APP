package org.pursuit.githubapi_app.presenter.item_search;

import android.annotation.SuppressLint;

import org.pursuit.githubapi_app.common.GHRetrofit;
import org.pursuit.githubapi_app.data.GithubApi;
import org.pursuit.githubapi_app.data.model.Items;
import org.pursuit.githubapi_app.data.model.ItemsResponse;
import org.pursuit.githubapi_app.presenter.Contract;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ItemsPresenter implements Contract.ItemsPresenter {

    private final Contract.ItemsView itemsView;
    private final GithubApi githubApi;

    public ItemsPresenter(Contract.ItemsView itemsView, GithubApi githubApi) {
        this.itemsView = itemsView;
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
                .subscribe((ItemsResponse response) -> {
                            List<Items> itemsList = new ArrayList<>(response.getItemsResponse());
                            itemsView.showItems(itemsList);
                        },
                        throwable -> itemsView.showError());
    }
}

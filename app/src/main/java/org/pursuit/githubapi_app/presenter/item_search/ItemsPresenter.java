package org.pursuit.githubapi_app.presenter.item_search;

import android.annotation.SuppressLint;

import org.pursuit.githubapi_app.network.GHRetrofit;
import org.pursuit.githubapi_app.network.GithubApi;
import org.pursuit.githubapi_app.data.model.Items;
import org.pursuit.githubapi_app.presenter.Contract;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created to override methods of ItemsPresenter. This allows information to operate without the data and UI
 * being held up by the other.
 */
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
                .subscribe((response) -> {
                            viewResponse(response.getItemsResponse());
                        },
                        throwable -> itemsView.showError());
    }

    private void viewResponse(List<Items> response) {
        List<Items> list = new ArrayList<>(response);
        final boolean success = !list.isEmpty();
        if (success) {
            itemsView.showItems(response);
        } else {
            itemsView.showError();
        }
    }
}

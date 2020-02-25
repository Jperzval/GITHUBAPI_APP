package org.pursuit.githubapi_app.presenter.repos;

import android.annotation.SuppressLint;

import org.pursuit.githubapi_app.common.GHRetrofit;
import org.pursuit.githubapi_app.data.DataSort;
import org.pursuit.githubapi_app.data.GithubApi;
import org.pursuit.githubapi_app.data.model.Repos;
import org.pursuit.githubapi_app.presenter.Contract;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created to override methods of RepoPresenter. This allows information to operate without the data and UI
 * being held up by the other.
 */
public class RepoPresenter implements Contract.RepoPresenter {

    private final Contract.RepoView repoView;
    private final GithubApi githubApi;

    public RepoPresenter(Contract.RepoView repoView, GithubApi githubApi) {
        this.repoView = repoView;
        this.githubApi = githubApi;
    }

    @SuppressLint("CheckResult")
    @Override
    public void getRepos(String organization) {
        GHRetrofit.getRetrofitInstance()
                .create(GithubApi.class)
                .getRepos(organization)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::viewResponse,
                        throwable -> repoView.showError());
    }

    private void viewResponse(List<Repos> response) {
        List<Repos> list = new ArrayList<>(response);
        final boolean success = !list.isEmpty();
        if (success) {
            DataSort.sortByStars(response);
            repoView.showRepos(response);
        } else {
            repoView.showError();
        }
    }
}

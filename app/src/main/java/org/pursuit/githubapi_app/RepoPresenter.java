package org.pursuit.githubapi_app;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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
                .subscribe((List<Repos> response) -> {
                            List<Repos> list = new ArrayList<>(response);
                            DataSort.sortByStars(list);
                            for (Repos r : list) {
                                System.out.println(r);
                            }
                            repoView.showRepos(list);
                        },
                        throwable -> repoView.showError());
    }
}

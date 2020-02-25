package org.pursuit.githubapi_app.presenter.repos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.pursuit.githubapi_app.presenter.item_search.ItemsViewHolder;
import org.pursuit.githubapi_app.R;
import org.pursuit.githubapi_app.common.GHRetrofit;
import org.pursuit.githubapi_app.data.GithubApi;
import org.pursuit.githubapi_app.data.model.Repos;
import org.pursuit.githubapi_app.presenter.Contract;

import java.util.List;

/**
 * Created to receive intent for each itemview's login name from ItemsViewHolder.
 */
public class RepoActivity extends AppCompatActivity implements Contract.RepoView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo);
        Intent intent = getIntent();
        String orgName = intent.getStringExtra(ItemsViewHolder.ORG_NAME);
        GithubApi api = GHRetrofit.getRetrofitInstance()
                .create(GithubApi.class);
        Contract.RepoPresenter presenter = new RepoPresenter(this, api);
        presenter.getRepos(orgName);
    }

    @Override
    public void showRepos(List<Repos> repos) {
        RecyclerView recyclerView = findViewById(R.id.repo_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new RepoAdapter(repos));
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    @Override
    public void showError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }
}

package org.pursuit.githubapi_app.presenter.item_search;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.widget.Toast;

import org.pursuit.githubapi_app.R;
import org.pursuit.githubapi_app.network.GHRetrofit;
import org.pursuit.githubapi_app.network.GithubApi;
import org.pursuit.githubapi_app.data.model.Items;
import org.pursuit.githubapi_app.presenter.Contract;

import java.util.List;

public class SearchActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, Contract.ItemsView {

    private Contract.ItemsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(this);
        searchView.clearFocus();
        GithubApi api = GHRetrofit.getRetrofitInstance()
                .create(GithubApi.class);
        presenter = new ItemsPresenter(this, api);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        String input = s.toLowerCase();
        presenter.getItemCall(input);
        return false;
    }

    @Override
    public void showItems(List<Items> itemsList) {
        RecyclerView recyclerView = findViewById(R.id.search_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new ItemsAdapter(itemsList));
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    @Override
    public void showError1() {
        Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError2() {
        Toast.makeText(this, "Enter New Search", Toast.LENGTH_SHORT).show();
    }
}

package org.pursuit.githubapi_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, Contract.SearchItemsView {

    private Contract.ItemPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(this);
        GithubApi api = GHRetrofit.getRetrofitInstance()
                .create(GithubApi.class);
        presenter = new SearchPresenter( this, api);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        String input = s.toLowerCase();
        System.out.println(input);
        presenter.getItemCall(input);
        return false;
    }

    @Override
    public void showItems(List<Item> itemList) {
        RecyclerView recyclerView = findViewById(R.id.search_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new ItemAdapter(itemList));
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    @Override
    public void showError(){
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }
}

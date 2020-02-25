package org.pursuit.githubapi_app;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoViewHolder> {

    private List<Repos> reposList;

    public RepoAdapter(List<Repos> reposList) {
        this.reposList = reposList;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.itemview_repos, viewGroup, false);
        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder repoViewHolder, int i) {
        repoViewHolder.onBind(reposList.get(i));
    }

    @Override
    public int getItemCount() {
        return reposList.size();
    }

    public void setData(List<Repos> sortList){
        this.reposList = sortList;
        notifyDataSetChanged();
    }
}

package org.pursuit.githubapi_app;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class RepoViewHolder extends RecyclerView.ViewHolder {

    private TextView repoNameView;

    public RepoViewHolder(@NonNull View itemView) {
        super(itemView);
        repoNameView = itemView.findViewById(R.id.repo_view);
    }

    public void onBind(final Repos repos) {
        repoNameView.setText(repos.getRepoName());
        itemView.setOnClickListener(v -> {
            //TODO
        });
    }
}

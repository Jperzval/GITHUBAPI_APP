package org.pursuit.githubapi_app;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.customtabs.CustomTabsIntent;
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
            String html_url = repos.getHtmlUrl();
            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
            builder.setToolbarColor(v.getResources().getColor(R.color.colorPrimary));
            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(v.getContext(), Uri.parse(html_url));
        });
    }
}

package org.pursuit.githubapi_app.presenter.item_search;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.pursuit.githubapi_app.R;
import org.pursuit.githubapi_app.data.model.Items;
import org.pursuit.githubapi_app.presenter.repos.RepoActivity;

public class ItemsViewHolder extends RecyclerView.ViewHolder {

    public static final String ORG_NAME = "orgName";
    private TextView itemNameView;

    public ItemsViewHolder(@NonNull View itemView) {
        super(itemView);
        itemNameView = itemView.findViewById(R.id.item_name_view);
    }

    public void onBind(final Items items) {
           itemNameView.setText(items.getLoginName());
           itemView.setOnClickListener(v -> {
               Intent intent = new Intent(itemView.getContext(), RepoActivity.class);
               intent.putExtra(ORG_NAME, items.getLoginName());
               v.getContext().startActivity(intent);
           });
    }

}

package org.pursuit.githubapi_app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    public static final String ORG_NAME = "orgName";
    private TextView itemNameView;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        itemNameView = itemView.findViewById(R.id.item_name_view);
    }

    public void onBind(final Item item) {
        itemNameView.setText(item.getLoginName());
        itemView.setOnClickListener(v -> {
            Toast.makeText(itemView.getContext(), "Clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(itemView.getContext(), RepoActivity.class);
            intent.putExtra(ORG_NAME, item.getLoginName());
            v.getContext().startActivity(intent);
        });
    }

}

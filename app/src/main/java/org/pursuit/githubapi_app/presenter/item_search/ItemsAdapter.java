package org.pursuit.githubapi_app.presenter.item_search;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.githubapi_app.R;
import org.pursuit.githubapi_app.data.model.Items;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsViewHolder> {

    private List<Items> itemsList;

    public ItemsAdapter(List<Items> itemsList) {
        this.itemsList = itemsList;
    }

    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.itemview_items, viewGroup, false);
        return new ItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsViewHolder itemsViewHolder, int i) {
        itemsViewHolder.onBind(itemsList.get(i));
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

}

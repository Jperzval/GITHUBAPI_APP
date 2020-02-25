package org.pursuit.githubapi_app;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemResponse {

//    @SerializedName("total_count")
//    private int totalCount;
//    @SerializedName("incomplete_result")
//    private boolean results;
    @SerializedName("items")
    private List<Item> itemResponse;

    public ItemResponse(List<Item> itemResponse) {
        this.itemResponse = itemResponse;
    }

    //No setters needed b/c its included within the retrofit converter
    public List<Item> getItemResponse() {
        return itemResponse;
    }

    public void setItemResponse(List<Item> itemResponse) {
        this.itemResponse = itemResponse;
    }
}

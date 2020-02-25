package org.pursuit.githubapi_app.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 *Created to obtain list of items
 */
public class ItemsResponse {

    @SerializedName("items")
    private List<Items> itemsResponse;

    //No setters needed b/c its included within the retrofit converter
    public List<Items> getItemsResponse() {
        return itemsResponse;
    }
}

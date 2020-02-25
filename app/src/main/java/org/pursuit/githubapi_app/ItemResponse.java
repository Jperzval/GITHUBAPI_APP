package org.pursuit.githubapi_app;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 *Created to obtain list of items
 */
public class ItemResponse {

    @SerializedName("items")
    private List<Item> itemResponse;

    //No setters needed b/c its included within the retrofit converter
    public List<Item> getItemResponse() {
        return itemResponse;
    }
}

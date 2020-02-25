package org.pursuit.githubapi_app;

import com.google.gson.annotations.SerializedName;

/**
 * Created to obtain item information
 */
public class Item {

    @SerializedName("login")
    private String loginName;
    @SerializedName("repos_url")
    private String reposUrl;

    //No setters needed b/c its included within the retrofit converter
    public String getLoginName() {
        return loginName;
    }

    public String getReposUrl() {
        return reposUrl;
    }
}

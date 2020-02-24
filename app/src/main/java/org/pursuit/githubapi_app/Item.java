package org.pursuit.githubapi_app;

import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("login")
    private String loginName;
    @SerializedName("repos_url")
    private String reposUrl;

    public Item(String loginName, String reposUrl) {
        this.loginName = loginName;
        this.reposUrl = reposUrl;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getReposUrl() {
        return reposUrl;
    }
}

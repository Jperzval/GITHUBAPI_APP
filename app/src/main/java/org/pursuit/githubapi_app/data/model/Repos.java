package org.pursuit.githubapi_app.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created to obtain repo information
 */
public class Repos {

    @SerializedName("name")
    private String repoName;

    @SerializedName("html_url")
    private String htmlUrl;

    @SerializedName("stargazers_count")
    private int starCount;

    //Constructor with parameters created for unit testing
    public Repos(String repoName, String htmlUrl, int starCount) {
        this.repoName = repoName;
        this.htmlUrl = htmlUrl;
        this.starCount = starCount;
    }

    //No setters needed b/c its included within the retrofit converter
    public String getRepoName() {
        return repoName;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public int getStarCount() {
        return starCount;
    }
}

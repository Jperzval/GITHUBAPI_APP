package org.pursuit.githubapi_app;

import java.util.List;

public class ReposResponse {

    private List<Repos> reposResponse;

    public ReposResponse(List<Repos> reposResponse) {
        this.reposResponse = reposResponse;
    }

    public List<Repos> getReposResponse() {
        return reposResponse;
    }

    public void setReposResponse(List<Repos> reposResponse) {
        this.reposResponse = reposResponse;
    }
}

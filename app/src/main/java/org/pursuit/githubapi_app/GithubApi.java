package org.pursuit.githubapi_app;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GithubApi {

    //Using query for the name of the organization
    @GET("search/users")
    Observable<ItemResponse> getItemResponse(@Query("q") String name);

    //Using path for the name of the organization
    @GET("users/{name}/repos")
    Observable<List<Repos>> getRepos(@Path("organization") String name);
}

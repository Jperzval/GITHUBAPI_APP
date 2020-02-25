package org.pursuit.githubapi_app.data;

import org.pursuit.githubapi_app.data.model.ItemsResponse;
import org.pursuit.githubapi_app.data.model.Repos;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GithubApi {
    //This does all the JSON parsing. It is the connecting piece to the API.
    @GET("search/users")
    Observable<ItemsResponse> getItemResponse(@Query("q") String name);

    @GET("users/{name}/repos")
    Observable<List<Repos>> getRepos(@Path("name") String name);
}

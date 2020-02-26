package org.pursuit.githubapi_app.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit singleton created for use of GithubApi
 */
public class GHRetrofit {

    private static final String GBAPI_BASE_URL = "https://api.github.com/";

    private static Retrofit retrofitInstance;

    public GHRetrofit() {
    }

    public static Retrofit getRetrofitInstance() {
        if (retrofitInstance == null) {
            //Getting/creating an instance of base URL - Avoids creating multiple instances.
            retrofitInstance = new Retrofit.Builder()
                    .baseUrl(GBAPI_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofitInstance;
    }
}

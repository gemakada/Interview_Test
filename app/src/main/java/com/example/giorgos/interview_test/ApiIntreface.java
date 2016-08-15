package com.example.giorgos.interview_test;

import retrofit2.http.GET;
 // import info.androidhive.retrofit.model.MoviesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
/**
 * Created by Giorgos on 12/8/2016.
 */
public class ApiIntreface {

    public interface ApiInterface {
       // @GET("movie/top_rated")
        //Call<VenuesResponse> getNearVenues(@Query("api_key") String apiKey);

        @GET("venues/search")

        //@GET("movie/{id}")
        Call<VenuesResponse> getNearVenues(@Query("client_id") String client_id, @Query("client_secret") String CLIENT_SECRET,@Query("v")String version, @Query("ll") String coord );

        @GET("venues/{id}")

        Call <VenueResults> getVenueResults(@Path("id") String id, @Query("client_id") String client_id, @Query("client_secret") String CLIENT_SECRET,@Query("v") String version  );
    }
}

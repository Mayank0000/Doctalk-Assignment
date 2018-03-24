package com.freelance.docstalk.Service;


import com.freelance.docstalk.Model.GitModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Shubham Shukla on 27-11-2017.
 */

public interface GitInterface {
    @GET("search/users")
    Call<GitModel> Gitresponse(@Query("q") String q, @Query("sort") String sort);
}

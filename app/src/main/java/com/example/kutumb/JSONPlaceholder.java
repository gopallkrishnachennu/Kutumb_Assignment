package com.example.kutumb;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceholder {
    @GET("repositories")
    Call<List<Post>> getPost();
}

package com.example.popularmovies.data

import android.content.res.Resources
import com.example.popularmovies.R
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("/3/discover/movie?" +
            "api_key=f839d77f3ba544f9a537d7a8f0a7d48f" +
            "&language=en-US" +
            "&sort_by=popularity.desc" +
            "&include_adult=false" +
            "&include_video=false" +
            "&page=1")
    fun getMovieList(@Query("year") year: String): Call<List<Movie>>
}
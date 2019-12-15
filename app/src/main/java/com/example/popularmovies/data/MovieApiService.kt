package com.example.popularmovies.data

import com.example.popularmovies.R
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("/movie?api_key=${R.string.movie_db_api_key}" +
            "&language=en-US" +
            "&sort_by=popularity.desc" +
            "&include_adult=false" +
            "&include_video=false" +
            "&page=1")
    fun getMovieList(@Query("year") year: String): Call<Movie>
}
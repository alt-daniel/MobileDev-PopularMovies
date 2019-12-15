package com.example.popularmovies.model

import androidx.lifecycle.MutableLiveData
import com.example.popularmovies.data.Movie
import com.example.popularmovies.data.MoviesRepository
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel {

    private val moviesRepository = MoviesRepository()
    val movies = MutableLiveData<List<Movie>>()
    val error = MutableLiveData<String>()

    fun getMovies(year: String) {
        moviesRepository.getMovies(year).enqueue(object: Callback<Movie> {

            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {

                val results = response.body()?.get("results")
                // puts the results in an array of type movie
                val movies = GsonBuilder().create().fromJson(results,Array<Movie>::class.java).toList()
//                val movies = GsonBuilder().create().fromJson(results,Array<Movie>::class.java).toList()

                //sets the ids
                for ((num) in movies.withIndex()) {
                    movies[num].id = num+1
                }
                if (response.isSuccessful){
                    this@MainActivityViewModel.movies.value = movies
                }
                else error.value = "An error occured: ${response.errorBody().toString()}"
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                error.value = t.message
            }

        })
    }

}
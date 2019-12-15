package com.example.popularmovies.model

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.popularmovies.data.Movie
import com.example.popularmovies.data.MoviesRepository
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel (application: Application) : AndroidViewModel(application) {

    private val moviesRepository = MoviesRepository()
    val movies = MutableLiveData<List<Movie>>()
    val error = MutableLiveData<String>()

    fun getMovies(year: String) {
        moviesRepository.getMovies(year).enqueue(object: Callback<List<Movie>> {

            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                if (response.isSuccessful) movies.value = response.body()
                else error.value = "An error ocurred: ${response.errorBody().toString()}"
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                error.value = t.message
            }

        })
    }

}
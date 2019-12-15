package com.example.popularmovies.data

class MoviesRepository {
private val movieApi : MovieApiService = MovieApi.createApi()

    fun getMovies(year : String) = movieApi.getMovieList(year)
}
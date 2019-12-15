package com.example.popularmovies.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieApi {

    companion object {
        //Base url from the api.
        private const val baseUrl = "https://api.themoviedb.org/"

        /**
         * return [NumbersApiService] - The service class of the retrofit client.
         */
        fun createApi(): MovieApiService {

            // Create an OkHttpClient to be able to make a log of the network traffic
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

            // Create the Retrofit instance
            val movieApi = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            // Return the Retrofit NumbersApiService
            return movieApi.create(MovieApiService::class.java)
        }
    }
}
package com.example.popularmovies.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (
    @SerializedName("title") var title: String,
    @SerializedName("release_date") var date: String,
    @SerializedName("vote_average") var voteAverage: String,
    @SerializedName("overview") var overview: String,
    @SerializedName("poster_path") var posterPath: String,
    @SerializedName("backdrop_path") var backdropPath: String,
    var id: Int
) : Parcelable {

    fun getPosterImageURL() {
        "https://image.tmdb.org/t/p/w500/$posterPath"
    }

    fun getBackdropImage() {
        "https://image.tmdb.org/t/p/w500/$backdropPath"
    }
}
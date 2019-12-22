package com.example.popularmovies.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (
    @SerializedName("backdrop_path") var backdropImage: String,
    @SerializedName("poster_path") var posterImage: String,
    @SerializedName("title") var title: String,
    @SerializedName("release_date") var releaseDate: String,
    @SerializedName("vote_average") var rating: Double,
    @SerializedName("overview") var overview: String,
    var id: Int
)  :Parcelable{

    fun getPosterImageURL() : String {
        return "https://image.tmdb.org/t/p/w500/$posterImage"
    }

    fun getBackdropImageUrl() : String {
        return "https://image.tmdb.org/t/p/w500/$backdropImage"
    }
}
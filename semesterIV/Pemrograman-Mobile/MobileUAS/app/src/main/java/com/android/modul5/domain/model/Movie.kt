package com.android.modul5.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.io.Serial

@Serializable
data class MovieResponse(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)

@Serializable
data class Movie(
    val id: Int,
    val popularity: Double,
    @SerialName("original_language")
    val originalLanguage: String,
//    @SerialName("origin_country")
//    val originCountry: String,
//    @SerialName("genre_ids")
//    val genreIds: List<Int>?,
    val overview: String,
    @SerialName("poster_path")
    val posterPath: String?,
//    @SerialName("backdrop_path")
//    val backdropPath: String,
    @SerialName("release_date")
    val releaseDate: String,
    val title: String,
    @SerialName("vote_average")
    val voteAverage: Double,
//    @SerialName("runtime")
//    val runtime: Int,
//    val status: String,
//    val tagline: String
)

@Serializable
data class MovieDetail(
    val id: Int,
    val popularity: Double,
    @SerialName("original_language")
    val originalLanguage: String,
    @SerialName("origin_country")
    val originCountry: List<String>,
    @SerialName("genres")
    val genre: List<Genre>,
    val overview: String,
    @SerialName("poster_path")
    val posterPath: String?,
//    @SerialName("backdrop_path")
//    val backdropPath: String,
    @SerialName("release_date")
    val releaseDate: String,
    val title: String,
    @SerialName("vote_average")
    val voteAverage: Double,
//    @SerialName("runtime")
//    val runtime: Int,
//    val status: String,
//    val tagline: String
)

@Serializable
data class Genre(
    val id: Int,
    val name: String,
)

// berhubung ni crash kemungkinan karena di list movie ada tapi pas di serach kdd begitupun sebliknya, esok coba pisah data classnya
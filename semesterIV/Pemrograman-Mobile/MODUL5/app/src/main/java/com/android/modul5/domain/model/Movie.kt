package com.android.modul5.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
    val overview: String,
    @SerialName("poster_path")
    val posterPath: String?,
    @SerialName("release_date")
    val releaseDate: String,
    val title: String,
    @SerialName("vote_average")
    val voteAverage: Double,
)
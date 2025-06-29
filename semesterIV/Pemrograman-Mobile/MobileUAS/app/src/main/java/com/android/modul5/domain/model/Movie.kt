package com.android.modul5.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
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

@Entity(tableName = "favorite_movies")
@Serializable
data class Movie(
    @PrimaryKey
    val id: Int,
    val popularity: Double = 0.0,
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
    val releaseDate: String = "-",
    val title: String,
    @SerialName("vote_average")
    val voteAverage: Double = 0.0,
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
    @SerialName("runtime")
    val runtime: Int,
    val status: String,
    val tagline: String
)

@Serializable
data class Genre(
    val id: Int,
    val name: String,
)

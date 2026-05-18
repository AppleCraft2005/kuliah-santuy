package com.android.modul5.data.remote.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.io.Serial

@Serializable
data class MovieResponseDTO(
    val page: Int,
    val results: List<MovieDTO>,
    val total_pages: Int,
    val total_results: Int
)

@Serializable
data class MovieDTO(
    val id: Int,
    val popularity: Double = 0.0,
    @SerialName("original_language")
    val originalLanguage: String,
    val overview: String,
    @SerialName("poster_path")
    val posterPath: String?,
    @SerialName("release_date")
    val releaseDate: String = "-",
    val title: String,
)

@Serializable
data class MovieDetailDTO(
    val id: Int,
    val popularity: Double,
    @SerialName("original_language")
    val originalLanguage: String,
    @SerialName("origin_country")
    val originCountry: List<String>,
    @SerialName("genres")
    val genre: List<GenreDTO>,
    val overview: String,
    @SerialName("poster_path")
    val posterPath: String?,
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
data class GenreDTO(
    val id: Int,
    val name: String,
)

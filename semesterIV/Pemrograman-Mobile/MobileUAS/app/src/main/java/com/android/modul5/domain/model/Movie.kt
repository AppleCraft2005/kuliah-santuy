package com.android.modul5.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.modul5.data.remote.dto.GenreDTO
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.io.Serial

data class Movie(
    val id: Int,
    val popularity: Double = 0.0,
    val originalLanguage: String,
    val overview: String,
    val posterPath: String?,
    val releaseDate: String = "-",
    val title: String,
)

data class MovieDetail(
    val id: Int,
    val popularity: Double,
    val originalLanguage: String,
    val originCountry: List<String>,
    val genre: List<Genre>,
    val overview: String,
    val posterPath: String?,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
    val runtime: Int,
    val status: String,
    val tagline: String
)

data class Genre(
    val id: Int,
    val name: String
)
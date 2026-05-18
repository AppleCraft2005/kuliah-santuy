package com.android.modul5.domain.repository

import com.android.modul5.domain.model.Movie
import com.android.modul5.domain.model.MovieDetail
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface MovieRepository {
    suspend fun getPopularMovies(): List<Movie>
    suspend fun getAnimeMovies(): List<Movie>
    suspend fun getIndonesiaMovies(): List<Movie>
    suspend fun searchMovies(query: String): List<Movie>
    suspend fun getMovieDetail(movieId: Int): MovieDetail?

    fun getFavoriteMovies(): Flow<List<MovieDetail>>
    suspend fun addFavMovie(movie: MovieDetail)
    suspend fun removeFavMovie(movieId: Int)
    suspend fun isMovieFav(movieId: Int): Boolean
}


package com.android.modul5.domain.repository

import com.android.modul5.domain.model.Movie
import com.android.modul5.domain.model.MovieDetail
import com.android.modul5.domain.model.MovieResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface MovieRepository {
    suspend fun getPopularMovies(): Response<MovieResponse>
    suspend fun getAnimeMovies(): Response<MovieResponse>
    suspend fun getIndonesiaMovies(): Response<MovieResponse>
    suspend fun searchMovies(query: String): Response<MovieResponse>
    suspend fun getMovieDetail(movieId: Int): Response<MovieDetail>

    fun getFavoriteMovies(): Flow<List<Movie>>
    suspend fun addFavMovie(movie: Movie)
    suspend fun removeFavMovie(movieId: Int)
    suspend fun isMovieFav(movieId: Int): Boolean
}

//// problem untuk di solve besok
//* app crash saat di rotate
//* saat menekan detail di halaman favorit mode ofline, datanya null semua
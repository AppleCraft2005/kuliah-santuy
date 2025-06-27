package com.android.modul5.data.repository

import com.android.modul5.data.local.FavoriteMovieDAO
import com.android.modul5.data.remote.RetrofitClient
import com.android.modul5.data.remote.api.TMDBAPI
import com.android.modul5.domain.model.Movie
import com.android.modul5.domain.model.MovieDetail
import com.android.modul5.domain.model.MovieResponse
import com.android.modul5.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class MovieRepositoryImpl(
    private val DAO: FavoriteMovieDAO,
    private val API: TMDBAPI
): MovieRepository {
    private val API_KEY = RetrofitClient.APIKEY

    override fun getFavoriteMovies(): Flow<List<Movie>> {
        return DAO.getFavoriteMovies()
    }

    override suspend fun addFavMovie(movie: Movie) {
        DAO.addMovieToFav(movie)
    }

    override suspend fun removeFavMovie(movieId: Int) {
        DAO.removeMovieFromFav(movieId)
    }

    override suspend fun isMovieFav(movieId: Int): Boolean {
        return DAO.checkMovie(movieId) > 0
    }

    override suspend fun getMovieDetail(movieId: Int): Response<MovieDetail> {
        return API.getMovieDetailbyID(movieId, API_KEY)
    }

    override suspend fun searchMovies(query: String): Response<MovieResponse> {
        return API.getMoviesbySearch(API_KEY, query)
    }

    override suspend fun getPopularMovies(): Response<MovieResponse> {
        return API.getPopularMovies(API_KEY)
    }

    override suspend fun getAnimeMovies(): Response<MovieResponse> {
        return API.getAnimeMovies(API_KEY)
    }

    override suspend fun getIndonesiaMovies(): Response<MovieResponse> {
        return API.getIndonesiaMovies(API_KEY)
    }
}
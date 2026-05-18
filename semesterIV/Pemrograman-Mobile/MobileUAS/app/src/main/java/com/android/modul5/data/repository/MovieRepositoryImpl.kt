package com.android.modul5.data.repository

import com.android.modul5.data.local.FavoriteMovieDAO
import com.android.modul5.data.local.entity.MovieEntity
import com.android.modul5.data.mapper.toDetailMovie
import com.android.modul5.data.mapper.toMovie
import com.android.modul5.data.mapper.toMovieDetail
import com.android.modul5.data.mapper.toMovieEntity
import com.android.modul5.data.remote.RetrofitClient
import com.android.modul5.data.remote.api.TMDBAPI
import com.android.modul5.data.remote.dto.MovieDTO
import com.android.modul5.domain.model.Movie
import com.android.modul5.domain.model.MovieDetail
import com.android.modul5.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import retrofit2.Response
import java.io.IOException

class MovieRepositoryImpl(
    private val DAO: FavoriteMovieDAO,
    private val API: TMDBAPI
): MovieRepository {
    private val API_KEY = RetrofitClient.APIKEY

    override fun getFavoriteMovies(): Flow<List<MovieDetail>> {
        return DAO.getFavoriteMovies().map { entityList ->
            entityList.map { entity ->
                entity.toMovieDetail()
            }
        }
    }

    override suspend fun addFavMovie(movie: MovieDetail) {
        DAO.addMovieToFav(movie.toMovieEntity())
    }

    override suspend fun removeFavMovie(movieId: Int) {
        DAO.removeMovieFromFav(movieId)
    }

    override suspend fun isMovieFav(movieId: Int): Boolean {
        return DAO.checkMovie(movieId) > 0
    }

    override suspend fun getMovieDetail(movieId: Int): MovieDetail? {
        return try {
            val response = API.getMovieDetailbyID(movieId, API_KEY)
            if (response.isSuccessful) {
                response.body()?.toDetailMovie()
            }
            else { null }
        }
        catch (err: Exception) { null }
    }

    override suspend fun searchMovies(query: String): List<Movie> {
        return try {
            val response = API.getMoviesbySearch( API_KEY, query,)
            if (response.isSuccessful) {
                val MovieDTOList = response.body()?.results ?: emptyList()
                return MovieDTOList.map { it.toMovie() }
            }
            else {
                emptyList()
            }
        }
        catch (err: Exception) { emptyList() }
    }

    override suspend fun getPopularMovies(): List<Movie> {
        return try {
            val response = API.getPopularMovies(API_KEY)
            if (response.isSuccessful) {
                val MovieDTOList = response.body()?.results ?: emptyList()
                return MovieDTOList.map { it.toMovie() }
            }
            else {
                emptyList()
            }
        }
        catch (err: Exception) { emptyList() }
    }

    override suspend fun getAnimeMovies(): List<Movie> {
        return try {
            val response = API.getAnimeMovies(API_KEY)
            if (response.isSuccessful) {
                val MovieDTOList = response.body()?.results ?: emptyList()
                return MovieDTOList.map { it.toMovie() }
            }
            else { emptyList() }
        }
        catch (err: Exception) { emptyList() }
    }

    override suspend fun getIndonesiaMovies(): List<Movie> {
        return try {
            val response = API.getIndonesiaMovies(API_KEY)
            if (response.isSuccessful) {
                val MovieDTOList = response.body()?.results ?: emptyList()
                return MovieDTOList.map { it.toMovie() }
            }
            else { emptyList() }
        }
        catch (err: Exception) { emptyList() }
    }
}




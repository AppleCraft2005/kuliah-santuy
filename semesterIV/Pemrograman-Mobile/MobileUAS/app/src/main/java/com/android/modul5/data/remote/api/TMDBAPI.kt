package com.android.modul5.data.remote.api

import com.android.modul5.data.remote.dto.MovieDTO
import com.android.modul5.data.remote.dto.MovieDetailDTO
import com.android.modul5.data.remote.dto.MovieResponseDTO
import com.android.modul5.domain.model.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TMDBAPI {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apikey: String,
    ) : Response<MovieResponseDTO>

    @GET("discover/movie")
    suspend fun getIndonesiaMovies(
        @Query("api_key") apikey: String,
        @Query("with_origin_country") country: String = "ID",
        @Query("sort_by") popularity: String = "popularity.desc",
    ) : Response<MovieResponseDTO>

    @GET("discover/movie")
    suspend fun getAnimeMovies(
        @Query("api_key") apikey: String,
        @Query("with_genres") genre: Int = 16,
        @Query("with_origin_country") country: String = "JP",
        @Query("sort_by") popularity: String = "popularity.desc",
    ) : Response<MovieResponseDTO>

    @GET("search/movie")
    suspend fun getMoviesbySearch(
        @Query("api_key") apikey: String,
        @Query("query") query: String,
    ) : Response<MovieResponseDTO>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetailbyID(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apikey: String,
    ) : Response<MovieDetailDTO>
}
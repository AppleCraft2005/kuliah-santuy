package com.android.modul5.data.remote.api

import com.android.modul5.domain.model.Movie
import com.android.modul5.domain.model.MovieDetail
import com.android.modul5.domain.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TMDBAPI {
//    @GET("discover/movie")
//    suspend fun getPopularMovies(
//        @Query("api_key") apikey: String,
//        @Query("with_original_language") lang: String = "id",
//        @Query("with_genres") genre: Int = 35,
//    ) : Response<MovieResponse>

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apikey: String,
    ) : Response<MovieResponse>

    @GET("discover/movie")
    suspend fun getIndonesiaMovies(
        @Query("api_key") apikey: String,
        @Query("with_origin_country") country: String = "ID",
        @Query("sort_by") popularity: String = "popularity.desc",
    ) : Response<MovieResponse>

    @GET("discover/movie")
    suspend fun getAnimeMovies(
        @Query("api_key") apikey: String,
        @Query("with_genres") genre: Int = 16,
        @Query("with_origin_country") country: String = "JP",
        @Query("sort_by") popularity: String = "popularity.desc",
    ) : Response<MovieResponse>

    @GET("search/movie")
    suspend fun getMoviesbySearch(
        @Query("api_key") apikey: String,
        @Query("query") query: String = "naruto",
    ) : Response<MovieResponse>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetailbyID(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apikey: String,
    ) : Response<MovieDetail>

//    @GET("genre/movie/list")
//    suspend fun getMovieGenres(
//        @Query("api_key") apiKey: String,
//        @Query("language") language: String = "en-US"
//    ): Response<GenreListDTO>
}
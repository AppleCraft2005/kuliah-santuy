package com.android.modul5.api
import com.android.modul5.data.Movie
import com.android.modul5.data.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TMDBAPI {
    @GET("discover/movie")
    suspend fun getPopularMovies(
        @Query("api_key") apikey: String,
        @Query("with_original_language") lang: String = "id",
        @Query("with_genres") genre: Int = 35,
        @Query("page") page: Int = 1,
    ) : Response<MovieResponse>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetailbyID(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apikey: String,
    ) : Response<Movie>
}
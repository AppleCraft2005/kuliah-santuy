package com.android.modul5.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.modul5.data.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteMovieDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovieToFav(movie: MovieEntity)

    @Query("SELECT * FROM favorite_movies")
    fun getFavoriteMovies(): Flow<List<MovieEntity>>

    @Query("DELETE FROM favorite_movies WHERE favorite_movies.id = :id")
    suspend fun removeMovieFromFav(id: Int): Int

    @Query("SELECT count(*) FROM favorite_movies WHERE favorite_movies.id = :id")
    suspend fun checkMovie(id: Int): Int
}
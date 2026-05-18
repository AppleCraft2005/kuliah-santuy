package com.android.modul5.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.android.modul5.data.local.entity.MovieEntity
import com.android.modul5.data.local.utils.Converter

@Database(entities = [MovieEntity::class], version = 5, exportSchema = false)
@TypeConverters(Converter::class)
abstract class MovieDatabase: RoomDatabase() {
    abstract fun favoriteMovieDAO(): FavoriteMovieDAO

    companion object {
        @Volatile
        private var INSTANCE: MovieDatabase? = null
        fun getDatabase(context: Context): MovieDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MovieDatabase::class.java,
                    "movie_database"
                )
                    .fallbackToDestructiveMigration(true)
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}

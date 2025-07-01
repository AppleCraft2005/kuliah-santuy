package com.android.modul5.domain.usecase

import com.android.modul5.domain.model.Movie
import com.android.modul5.domain.model.MovieDetail
import com.android.modul5.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteMoviesUseCase(private val repository: MovieRepository) {
    operator fun invoke(): Flow<List<MovieDetail>> {
        return repository.getFavoriteMovies()
    }
}
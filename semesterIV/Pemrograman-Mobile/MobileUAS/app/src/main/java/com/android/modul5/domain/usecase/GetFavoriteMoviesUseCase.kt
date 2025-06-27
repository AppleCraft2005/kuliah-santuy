package com.android.modul5.domain.usecase

import com.android.modul5.domain.model.Movie
import com.android.modul5.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteMoviesUseCase(private val repository: MovieRepository) {
    operator fun invoke(): Flow<List<Movie>> {
        return repository.getFavoriteMovies()
    }
}
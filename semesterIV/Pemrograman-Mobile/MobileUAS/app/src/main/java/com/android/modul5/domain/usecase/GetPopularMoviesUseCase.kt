package com.android.modul5.domain.usecase

import com.android.modul5.domain.model.Movie
import com.android.modul5.domain.repository.MovieRepository

class GetPopularMoviesUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke(): List<Movie> {
        return repository.getPopularMovies()
    }
}

package com.android.modul5.domain.usecase

import com.android.modul5.domain.model.Movie
import com.android.modul5.domain.repository.MovieRepository

class SearchMoviesUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke(query: String): List<Movie> {
        return repository.searchMovies(query)
    }
}

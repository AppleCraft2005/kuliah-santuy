package com.android.modul5.domain.usecase

import com.android.modul5.domain.repository.MovieRepository

class RemoveFavMovieUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke(movieId: Int) {
        repository.removeFavMovie(movieId)
    }
}
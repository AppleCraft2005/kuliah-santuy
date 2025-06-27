package com.android.modul5.domain.usecase

import com.android.modul5.domain.repository.MovieRepository

class CheckFavMovieUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke(movieId: Int): Boolean {
        return repository.isMovieFav(movieId)
    }
}
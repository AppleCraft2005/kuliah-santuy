package com.android.modul5.domain.usecase

import com.android.modul5.domain.model.Movie
import com.android.modul5.domain.model.MovieDetail
import com.android.modul5.domain.repository.MovieRepository

class AddFavMovieUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke(movie: MovieDetail) {
        repository.addFavMovie(movie)
    }
}
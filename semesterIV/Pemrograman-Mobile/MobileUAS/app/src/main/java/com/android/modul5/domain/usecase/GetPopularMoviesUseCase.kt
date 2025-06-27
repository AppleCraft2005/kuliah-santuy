package com.android.modul5.domain.usecase

import com.android.modul5.domain.model.MovieResponse
import com.android.modul5.domain.repository.MovieRepository
import retrofit2.Response

class GetPopularMoviesUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke(): Response<MovieResponse> {
        return repository.getPopularMovies()
    }
}
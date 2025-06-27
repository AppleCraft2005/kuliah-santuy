package com.android.modul5.domain.usecase

import com.android.modul5.domain.model.MovieResponse
import com.android.modul5.domain.repository.MovieRepository
import retrofit2.Response

class SearchMoviesUseCase(private val repository: MovieRepository) {
    suspend fun invoke(query: String): Response<MovieResponse> {
        return repository.SearchMovies(query)
    }
}
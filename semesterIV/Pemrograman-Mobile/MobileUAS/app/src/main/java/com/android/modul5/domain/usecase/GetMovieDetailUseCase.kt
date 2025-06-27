package com.android.modul5.domain.usecase

import com.android.modul5.domain.model.MovieDetail
import com.android.modul5.domain.repository.MovieRepository
import retrofit2.Response

class GetMovieDetailUseCase(private val repository: MovieRepository) {
    suspend operator fun invoke(movieId: Int): Response<MovieDetail> {
        return repository.getMovieDetail(movieId)
    }
}
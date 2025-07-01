package com.android.modul5.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.modul5.domain.model.Movie
import com.android.modul5.domain.model.MovieDetail
import com.android.modul5.domain.usecase.GetFavoriteMoviesUseCase
import com.android.modul5.domain.usecase.RemoveFavMovieUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FavoriteMovieViewModel(
    private val getFavoriteMoviesUseCase: GetFavoriteMoviesUseCase,
    private val removeFavMovieUseCase: RemoveFavMovieUseCase
): ViewModel() {
    val favoriteMovies: StateFlow<List<MovieDetail>> = getFavoriteMoviesUseCase()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun removeMovieFromFav(movieId: Int) {
        viewModelScope.launch {
            removeFavMovieUseCase(movieId)
        }
    }
}
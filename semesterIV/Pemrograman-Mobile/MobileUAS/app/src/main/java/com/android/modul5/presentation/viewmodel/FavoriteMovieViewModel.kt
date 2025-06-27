package com.android.modul5.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.modul5.domain.model.Movie
import com.android.modul5.domain.usecase.GetFavoriteMoviesUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class FavoriteMovieViewModel(private val getFavoriteMoviesUseCase: GetFavoriteMoviesUseCase): ViewModel() {
    val favoriteMovies: StateFlow<List<Movie>> = getFavoriteMoviesUseCase()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )
}
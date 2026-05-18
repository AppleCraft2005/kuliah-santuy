package com.android.modul5.presentation.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.modul5.data.remote.RetrofitClient
import com.android.modul5.domain.model.Movie
import com.android.modul5.domain.model.MovieDetail
import com.android.modul5.domain.usecase.AddFavMovieUseCase
import com.android.modul5.domain.usecase.CheckFavMovieUseCase
import com.android.modul5.domain.usecase.GetMovieDetailUseCase
import com.android.modul5.domain.usecase.GetPopularMoviesUseCase
import com.android.modul5.domain.usecase.RemoveFavMovieUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import java.io.IOException

class MovieDetailViewModel (
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val checkFavMovieUseCase: CheckFavMovieUseCase,
    private val addFavMovieUseCase: AddFavMovieUseCase,
    private val removeFavMovieUseCase: RemoveFavMovieUseCase
): ViewModel() {
    private val _selectedMovieDetail = MutableStateFlow<MovieDetail?>(null)
    val selectedMovieDetail: StateFlow<MovieDetail?> = _selectedMovieDetail

    private val _isFavorite = MutableStateFlow(false)
    val isFavorite: StateFlow<Boolean> = _isFavorite.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _errorMsg = MutableStateFlow<String?>(null)
    val errorMsg: StateFlow<String?> = _errorMsg

    fun fetchMoviebyDetailbyID(movieId: Int) {

        if(_selectedMovieDetail.value?.id == movieId) {return}

        viewModelScope.launch {
            _errorMsg.value = null
            _isLoading.value = true

            val result = getMovieDetailUseCase(movieId)
            if (result != null) {
                _selectedMovieDetail.value = result
                Log.d("Movie Detail", "$result")
            }
            else {
                _errorMsg.value = "No Internet Connection"
            }
            _isLoading.value = false
            checkFavoriteStatus(movieId)
        }
    }

    fun onFavoriteClicked() {
        viewModelScope.launch {
            val movieDetail = _selectedMovieDetail.value ?: return@launch
            if (_isFavorite.value) {
                removeFavMovieUseCase(movieDetail.id)
                _isFavorite.value = false
            }
            else {
                addFavMovieUseCase(movieDetail)
                _isFavorite.value = true
            }
        }
    }

    fun checkFavoriteStatus(movieId: Int) {
        viewModelScope.launch {
            _isFavorite.value = checkFavMovieUseCase(movieId)
        }
    }
}

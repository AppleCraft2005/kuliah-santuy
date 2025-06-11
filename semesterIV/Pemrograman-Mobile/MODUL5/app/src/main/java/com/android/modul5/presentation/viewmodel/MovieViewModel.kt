package com.android.modul5.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.modul5.data.api.RetrofitClient
import com.android.modul5.domain.model.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel: ViewModel() {
    private val API_KEY = "9d2494a8a2a5c08592c8e963a74c799a"

    private val _Movies = MutableStateFlow<List<Movie>>(emptyList())
    val Movies: StateFlow<List<Movie>> = _Movies

    private val _selectedMovieDetail = MutableStateFlow<Movie?>(null)
    val selectedMovieDetail: StateFlow<Movie?> = _selectedMovieDetail

    private val _errorMsg = MutableStateFlow<String?>(null)
    val errorMsg: StateFlow<String?> = _errorMsg

    init {
        fetchMovies()
    }

    fun fetchMovies() {
        viewModelScope.launch {
            _errorMsg.value = null
            val Response = RetrofitClient.tmdbAPI.getPopularMovies(API_KEY)
            try {
                if (Response.isSuccessful) {
                    Response.body()?.let { _Movies.value = it.results }
                }
                else {_errorMsg.value = "Error in movie List= ${Response.code()} - ${Response.message()}"}
            }
            catch (err: Exception) {_errorMsg.value = "Exception: ${err.localizedMessage} ?: Unknown error"}
        }
    }

    fun fetchMoviebyDetailbyID(movieId: Int) {
        _errorMsg.value = null
        viewModelScope.launch {
            val responseDetail = RetrofitClient.tmdbAPI.getMovieDetailbyID(movieId,API_KEY)
            try {
                if (responseDetail.isSuccessful) {
                    _selectedMovieDetail.value = responseDetail.body()
                }
                else {_errorMsg.value = "Error in movie detail = ${responseDetail.code()} - ${responseDetail.message()}"}
            }
            catch (err: Exception) {_errorMsg.value = "Exception: ${err.localizedMessage} ?: Unknown error"}
        }
    }
}
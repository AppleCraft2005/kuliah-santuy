package com.android.modul5.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.modul5.data.api.RetrofitClient
import com.android.modul5.domain.model.Movie
import com.android.modul5.domain.model.MovieDetail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class MovieViewModel: ViewModel() {
    private val API_KEY = "9d2494a8a2a5c08592c8e963a74c799a"

    private val _Movies = MutableStateFlow<List<Movie>>(emptyList())
    val Movies: StateFlow<List<Movie>> = _Movies

    private val _selectedMovieDetail = MutableStateFlow<MovieDetail?>(null)
    val selectedMovieDetail: StateFlow<MovieDetail?> = _selectedMovieDetail

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _errorMsg = MutableStateFlow<String?>(null)
    val errorMsg: StateFlow<String?> = _errorMsg

    init {
        fetchMovies()
    }

    fun fetchMovies() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMsg.value = null
            val Response = RetrofitClient.tmdbAPI.getPopularMovies(API_KEY)
            try {
                if (Response.isSuccessful) {
                    Response.body()?.let {
                        _Movies.value = it.results
                        Log.d("TMDB Movie Response", Json.encodeToString(it))
                    }
                }
                else {
                    _errorMsg.value = "Error in movie List= ${Response.code()} - ${Response.message()}"
                }
            }
            catch (err: Exception) {
                _errorMsg.value = "Exception: ${err.localizedMessage} ?: Unknown error"
            }
            finally {
                _isLoading.value = false
            }
        }
    }

    fun fetchMoviebyDetailbyID(movieId: Int) {
        viewModelScope.launch {
            _errorMsg.value = null
            _isLoading.value = true
            val responseDetail = RetrofitClient.tmdbAPI.getMovieDetailbyID(movieId,API_KEY)
            try {
                if (responseDetail.isSuccessful) {
                   val movieDetail =   responseDetail.body()
                    _selectedMovieDetail.value = movieDetail

                    Log.d("Movie Detail", Json.encodeToString(movieDetail))
                }
                else {
                    _errorMsg.value = "Error in movie detail = ${responseDetail.code()} - ${responseDetail.message()}"
                }
            }
            catch (err: Exception) {
                _errorMsg.value = "Exception: ${err.localizedMessage} ?: Unknown error"
            }
            finally {
                _isLoading.value = false
            }
        }
    }
}
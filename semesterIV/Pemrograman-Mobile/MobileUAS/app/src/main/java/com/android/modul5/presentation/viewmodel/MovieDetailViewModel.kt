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

//class MovieDetailViewModel: ViewModel() {
//    private val API_KEY = "9d2494a8a2a5c08592c8e963a74c799a"
//
//    private val _selectedMovieDetail = MutableStateFlow<MovieDetail?>(null)
//    val selectedMovieDetail: StateFlow<MovieDetail?> = _selectedMovieDetail
//
//    private val _isLoading = MutableStateFlow(false)
//    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
//
//    private val _errorMsg = MutableStateFlow<String?>(null)
//    val errorMsg: StateFlow<String?> = _errorMsg
//
//    fun fetchMoviebyDetailbyID(movieId: Int) {
//        viewModelScope.launch {
//            _errorMsg.value = null
//            _isLoading.value = true
//            val responseDetail = RetrofitClient.tmdbAPI.getMovieDetailbyID(movieId,API_KEY)
//            try {
//                if (responseDetail.isSuccessful) {
//                    val movieDetail =   responseDetail.body()
//                    _selectedMovieDetail.value = movieDetail
//
//                    Log.d("Movie Detail", Json.encodeToString(movieDetail))
//                }
//                else {
//                    _errorMsg.value = "Error in movie detail = ${responseDetail.code()} - ${responseDetail.message()}"
//                }
//            }
//            catch (err: Exception) {
//                _errorMsg.value = "Exception: ${err.localizedMessage} ?: Unknown error"
//            }
//            finally {
//                _isLoading.value = false
//            }
//        }
//    }
//}

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
        viewModelScope.launch {
            _errorMsg.value = null
            _isLoading.value = true
            try {
                val responseDetail = getMovieDetailUseCase(movieId)
                if (responseDetail.isSuccessful) {
                    val movieDetail =   responseDetail.body()
                    _selectedMovieDetail.value = movieDetail

                    Log.d("Movie Detail", Json.encodeToString(movieDetail))
                }
                else {
                    _errorMsg.value = "Error in movie detail = ${responseDetail.code()} - ${responseDetail.message()}"
                }
            }
            catch (err: IOException) {
                _errorMsg.value = "No Internet Connection"
            }
            catch (err: Exception) {
                _errorMsg.value = "Exception: ${err.localizedMessage} ?: Unknown error"
            }
            finally {
                _isLoading.value = false
                checkFavoriteStatus(movieId)
            }
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
                val favoriteMovie = Movie(
                    id = movieDetail.id,
                    title = movieDetail.title,
                    posterPath = movieDetail.posterPath,
                    overview = movieDetail.overview,
                    releaseDate = movieDetail.releaseDate,
                    voteAverage = movieDetail.voteAverage,
                    popularity = movieDetail.popularity,
                    originalLanguage = movieDetail.originalLanguage,
                )
                addFavMovieUseCase(favoriteMovie)
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



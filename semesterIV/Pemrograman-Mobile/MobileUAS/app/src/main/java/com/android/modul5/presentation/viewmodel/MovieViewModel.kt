package com.android.modul5.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.modul5.domain.model.Movie
import com.android.modul5.domain.usecase.GetAnimeMoviesUseCase
import com.android.modul5.domain.usecase.GetIndonesiaMovieUseCase
import com.android.modul5.domain.usecase.GetPopularMoviesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import java.io.IOException

//class MovieViewModel: ViewModel() {
//    private val API_KEY = "9d2494a8a2a5c08592c8e963a74c799a"
//
//    private val _Movies = MutableStateFlow<List<Movie>>(emptyList())
//    val Movies: StateFlow<List<Movie>> = _Movies
//
//    private val _isLoading = MutableStateFlow(false)
//    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
//
//    private val _errorMsg = MutableStateFlow<String?>(null)
//    val errorMsg: StateFlow<String?> = _errorMsg
//
//    init {
//        fetchMovies()
//    }
//
//    fun fetchMovies() {
//        viewModelScope.launch {
//            _isLoading.value = true
//            _errorMsg.value = null
//            try {
//                val Response = RetrofitClient.tmdbAPI.getPopularMovies(API_KEY)
//                if (Response.isSuccessful) {
//                    Response.body()?.let {
//                        _Movies.value = it.results
//                        Log.d("TMDB Movie Response", Json.encodeToString(it))
//                    }
//                }
//                else {
//                    _errorMsg.value = "Error in movie List= ${Response.code()} - ${Response.message()}"
//                }
//            }
//            catch (err: IOException) {
//                _errorMsg.value = "No Internet Connection"
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

class MovieViewModel(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getNowPlayingMoviesUseCase: GetAnimeMoviesUseCase,
    private val getIndonesiaMovieUseCase: GetIndonesiaMovieUseCase
) : ViewModel() {
    private val _Movies = MutableStateFlow<List<Movie>>(emptyList())
    val Movies: StateFlow<List<Movie>> = _Movies

    private val _AnimeMovies = MutableStateFlow<List<Movie>>(emptyList())
    val AnimeMovies: StateFlow<List<Movie>> = _AnimeMovies

    private val _IndonesiaMovies = MutableStateFlow<List<Movie>>(emptyList())
    val IndonesiaMovies: StateFlow<List<Movie>> = _IndonesiaMovies

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
            try {
                val ResponsePopular = getPopularMoviesUseCase()
                val ResponseAnime = getNowPlayingMoviesUseCase()
                val ResponseIndonesia = getIndonesiaMovieUseCase()
                if (ResponsePopular.isSuccessful) {
                    ResponsePopular.body()?.let {
                        _Movies.value = it.results
                        Log.d("TMDB Movie Response (popular)", Json.encodeToString(it))
                    }
                }
                else {
                    _errorMsg.value = "Error in movie List= ${ResponsePopular.code()} - ${ResponsePopular.message()}"
                }
                if (ResponseIndonesia.isSuccessful) {
                    ResponseIndonesia.body()?.let {
                        _IndonesiaMovies.value = it.results
                        Log.d("TMDB Movie Response (Indonesia)", Json.encodeToString(it))
                    }
                }
                else {
                    _errorMsg.value = "Error in movie List= ${ResponseAnime.code()} - ${ResponseAnime.message()}"
                }
                if (ResponseAnime.isSuccessful) {
                    ResponseAnime.body()?.let {
                        _AnimeMovies.value = it.results
                        Log.d("TMDB Movie Response (Anime)", Json.encodeToString(it))
                    }
                }
                else {
                    _errorMsg.value = "Error in movie List= ${ResponseIndonesia.code()} - ${ResponseIndonesia.message()}"
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
            }
        }
    }
}
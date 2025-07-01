package com.android.modul5.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.modul5.domain.model.Movie
import com.android.modul5.domain.usecase.GetAnimeMoviesUseCase
import com.android.modul5.domain.usecase.GetIndonesiaMovieUseCase
import com.android.modul5.domain.usecase.GetPopularMoviesUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import java.io.IOException

class MovieViewModel(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getAnimeMoviesUseCase: GetAnimeMoviesUseCase,
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

            // mengambil popular, anime, indonesia movies secara async
            val popularDeferred = async{ getPopularMoviesUseCase() }
            val animeDeferred = async{ getAnimeMoviesUseCase() }
            val indonesiaDeferred = async{ getIndonesiaMovieUseCase() }

            // menunggu popular, anime, indonesia movies secara bersamaan lalu ambil hasilnya
            val popularMovies = popularDeferred.await()
            val animeMovies = animeDeferred.await()
            val indonesiaMovies = indonesiaDeferred.await()

            // menyimpan hasil yang didapat tadi dan menampilkan di log
            _Movies.value = popularMovies
            Log.d("TMDB Movie Response (popular)", "$popularMovies")

            // menyimpan hasil yang didapat tadi dan menampilkan di log
            _IndonesiaMovies.value = indonesiaMovies
            Log.d("TMDB Movie Response (Indonesia)", "$indonesiaMovies")

            // menyimpan hasil yang didapat tadi dan menampilkan di log
            _AnimeMovies.value = animeMovies
            Log.d("TMDB Movie Response (Anime)", "$animeMovies")

            if (popularMovies.isEmpty() && indonesiaMovies.isEmpty() && animeMovies.isEmpty()) {
                _errorMsg.value = "No Internet Connection"
            }
            _isLoading.value = false
        }
    }
}
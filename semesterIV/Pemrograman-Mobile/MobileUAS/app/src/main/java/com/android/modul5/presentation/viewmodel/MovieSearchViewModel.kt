package com.android.modul5.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.modul5.data.api.RetrofitClient
import com.android.modul5.domain.model.Movie
import com.android.modul5.domain.model.MovieResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import java.io.IOException

class MovieSearchViewModel : ViewModel() {
    private val API_KEY = "9d2494a8a2a5c08592c8e963a74c799a"

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _searchResults = MutableStateFlow<List<Movie>>(emptyList())
    val searchResults: StateFlow<List<Movie>> = _searchResults.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _errMsg = MutableStateFlow<String?>(null)
    val errMsg: StateFlow<String?> = _errMsg.asStateFlow()

    init {
        _searchQuery
            .debounce(300L)
            .filter { query ->
                query.isNotBlank() || query.isEmpty()
            }
            .distinctUntilChanged() // Hanya memicu jika query benar-benar berbeda dari sebelumnya
            .onEach { query ->
                println("Handling query: $query")
                if (query.isBlank()) {
                    _searchResults.value = emptyList()
                    _errMsg.value = null
                    _isLoading.value = false
                } else {
                    println("Mencari hasil untuk: $query")
                    fetchSearchResults(query) // Panggil fungsi pencarian
                }
            }
            .launchIn(viewModelScope) // Menjalankan Flow ini di dalam viewModelScope
    }

    /**
     * Memperbarui query pencarian. Dipanggil dari Composable TextField di UI.
     */
    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
    }

    /**
     * Mengambil hasil pencarian film dari TMDB API.
     */
    private fun fetchSearchResults(query: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _errMsg.value = null
            try {
                val response = RetrofitClient.tmdbAPI.getMoviesbySearch(apikey = API_KEY, query = query)
                if (response.isSuccessful) {
                   val Movie =  response.body()?.results ?: emptyList()
                    _searchResults.value = Movie

                    Log.d("Movie search", Json.encodeToString(Movie))
                }
                else {
                    _errMsg.value = "Error searching movies: ${response.code()} - ${response.message()}"
                }
            }
            catch (err: IOException) {
                _errMsg.value = "No Internet Connection"
            }
            catch (err: Exception) {
                _errMsg.value = "Exception searching movies: ${err.localizedMessage ?: "Unknown error"}"
            }
            finally {
                _isLoading.value = false
            }
        }
    }

    /**
     * Membersihkan state pencarian saat ini (query, hasil, error).
     */
    fun clearSearchResults() {
        _searchQuery.value = ""
        _searchResults.value = emptyList()
        _errMsg.value = null
        _isLoading.value = false
    }
}
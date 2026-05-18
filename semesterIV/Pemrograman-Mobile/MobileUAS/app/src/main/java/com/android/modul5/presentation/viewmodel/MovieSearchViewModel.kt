package com.android.modul5.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.modul5.data.remote.RetrofitClient
import com.android.modul5.domain.model.Movie
import com.android.modul5.domain.usecase.SearchMoviesUseCase
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

class MovieSearchViewModel(private val searchMoviesUseCase: SearchMoviesUseCase) : ViewModel() {
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _searchResults = MutableStateFlow<List<Movie>>(emptyList())
    val searchResults: StateFlow<List<Movie>> = _searchResults.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        _searchQuery
            .debounce(500L) // menunggu 0.5s sebelum mencari film
            .filter { query -> query.isNotBlank() || query.isEmpty() }
            .distinctUntilChanged() // melakukan pencarian jika teksnya berbeda dari yang dketik sebelumnya
            .onEach { query ->
                if (query.isBlank()) {
                    _searchResults.value = emptyList()
                    _isLoading.value = false
                } else {
                    fetchSearchResults(query)
                }
            }
            .launchIn(viewModelScope)
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
    }

    private fun fetchSearchResults(query: String) {
        viewModelScope.launch {
            _isLoading.value = true

            val result = searchMoviesUseCase(query)
            _searchResults.value = result
            Log.d("Movie search", "$result")

            _isLoading.value = false
        }
    }
}
package com.android.modul5.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.android.modul5.presentation.components.Card.MovieCard
import com.android.modul5.presentation.components.Text.TitleFirst
import com.android.modul5.presentation.components.LottieAnimation.noInternetAnimate
import com.android.modul5.presentation.components.LottieAnimation.waitingAnimate
import com.android.modul5.presentation.viewmodel.MovieSearchViewModel

@Composable
fun MovieSearchScreen( searchViewModel: MovieSearchViewModel, navController: NavController) {
    val searchQuery by searchViewModel.searchQuery.collectAsState()
    val searchResult by searchViewModel.searchResults.collectAsState()
    val isLoading by searchViewModel.isLoading.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleFirst("Search Movies")
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchViewModel.onSearchQueryChanged(it)},
            label = { Text("Insert Movies Title") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        )
        if (searchQuery.isBlank()) {
            waitingAnimate()
        }
        else if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.padding(16.dp))
        }
        else if(searchQuery.isNotBlank() && searchResult.isEmpty()){
            Text("No Movies Found!")
        }
        else {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 170.dp),
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(searchResult) {movie ->
                        MovieCard(movieItem = movie, navController = navController)
                }
            }
        }
    }
}
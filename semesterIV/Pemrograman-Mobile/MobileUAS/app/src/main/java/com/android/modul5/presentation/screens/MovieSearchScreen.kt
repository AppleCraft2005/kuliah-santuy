package com.android.modul5.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.android.modul5.presentation.components.MovieCard
import com.android.modul5.presentation.components.TitleFirst
import com.android.modul5.presentation.components.TopBar
import com.android.modul5.presentation.components.noInternetAnimate
import com.android.modul5.presentation.components.waitingAnimate
import com.android.modul5.presentation.ui.theme.MODUL5Theme
import com.android.modul5.presentation.viewmodel.MovieSearchViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MovieSearchScreen(navController: NavController, searchViewModel: MovieSearchViewModel = koinViewModel()) {
    val searchQuery by searchViewModel.searchQuery.collectAsState()
    val searchResult by searchViewModel.searchResults.collectAsState()
    val isLoading by searchViewModel.isLoading.collectAsState()
    val errMsg by searchViewModel.errMsg.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleFirst("Pencarian Film")
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchViewModel.onSearchQueryChanged(it)},
            label = { Text("Masukkan judul film") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)

        )
        
        if (errMsg != null) {
            if(errMsg == "No Internet Connection") {
                noInternetAnimate()
            }
            else {
                Text(errMsg!!)
            }
        }
        else if (searchQuery.isBlank()) {
            waitingAnimate()
        }
        else if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.padding(16.dp))
        }
        else if(searchQuery.isNotBlank() && searchResult.isEmpty()){
            Text("Tidak ada Film yang ditemukan!")
        }
        else {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 150.dp),
                modifier = Modifier.fillMaxWidth(),
//                    contentPadding = PaddingValues(8.dp),
//                    horizontalArrangement = Arrangement.spacedBy(8.dp),
//                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(searchResult) {movie ->
                        MovieCard(movieItem = movie, navController = navController)
                }
            }
        }
    }
}
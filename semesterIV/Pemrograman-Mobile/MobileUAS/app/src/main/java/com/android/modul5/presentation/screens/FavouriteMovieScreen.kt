package com.android.modul5.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.android.modul5.presentation.components.MovieCard
import com.android.modul5.presentation.components.Title
import com.android.modul5.presentation.components.TitleFirst
import com.android.modul5.presentation.viewmodel.FavoriteMovieViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavouriteMovieScreen(navController: NavController, favoriteMovieViewModel: FavoriteMovieViewModel = koinViewModel()) {
    val favoriteMovies by favoriteMovieViewModel.favoriteMovies.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleFirst("Film Favorit")

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 150.dp),
            modifier = Modifier.fillMaxWidth(),
//                    contentPadding = PaddingValues(8.dp),
//                    horizontalArrangement = Arrangement.spacedBy(8.dp),
//                    verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(favoriteMovies) {movie ->
                MovieCard(movieItem = movie, navController = navController)
            }
        }
    }

}
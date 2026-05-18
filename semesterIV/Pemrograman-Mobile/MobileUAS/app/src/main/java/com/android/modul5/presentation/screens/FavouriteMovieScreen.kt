package com.android.modul5.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.android.modul5.presentation.components.Card.MovieCardDetail
import com.android.modul5.presentation.components.Text.TitleFirst
import com.android.modul5.presentation.components.LottieAnimation.waitingAnimate
import com.android.modul5.presentation.viewmodel.FavoriteMovieViewModel

@Composable
fun FavouriteMovieScreen(favoriteMovieViewModel: FavoriteMovieViewModel, navController: NavController) {
    val favoriteMovies by favoriteMovieViewModel.favoriteMovies.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleFirst("Favorite Movies")
        if (favoriteMovies.isEmpty()) {
            Spacer(modifier = Modifier.height(12.dp))
            Text("No Favorite Movies here, please add one!")
            waitingAnimate()
        }
        else {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 270.dp),
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(favoriteMovies) {movie ->
                    MovieCardDetail(movieItem = movie, onFavClick = {favoriteMovieViewModel.removeMovieFromFav(it)})
                }
            }
        }
    }
}
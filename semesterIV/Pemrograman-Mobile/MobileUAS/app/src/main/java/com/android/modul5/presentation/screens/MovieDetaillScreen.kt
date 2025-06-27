package com.android.modul5.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.android.modul5.presentation.components.ButtonNav
import com.android.modul5.presentation.components.Desc
import com.android.modul5.presentation.components.Glide
import com.android.modul5.presentation.components.MovieCard
import com.android.modul5.presentation.components.Title
import com.android.modul5.presentation.components.TopBar
import com.android.modul5.presentation.components.noInternetAnimate
import com.android.modul5.presentation.viewmodel.MovieDetailViewModel
import com.android.modul5.presentation.viewmodel.MovieViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieDetailScreen(movieId: Int, movieDetalViewModel: MovieDetailViewModel, navController: NavController) {
    val movieDetail by movieDetalViewModel.selectedMovieDetail.collectAsState()
    val isFavorite by movieDetalViewModel.isFavorite.collectAsState()
    val errMsg by movieDetalViewModel.errorMsg.collectAsState()
    val isLoading by movieDetalViewModel.isLoading.collectAsState()
    val genreList = movieDetail?.genre
    val genreNames = genreList?.map { it.name }?.joinToString(", ")

    LaunchedEffect(movieId) {
        movieDetalViewModel.fetchMoviebyDetailbyID(movieId)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        if (errMsg != null) {
            if(errMsg == "No Internet Connection") {
                noInternetAnimate()
            }
            else {
                Text(errMsg!!)
            }
        }
        else if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.padding(16.dp))
        }
        else {
            Glide(movieDetail?.posterPath)
            Spacer(modifier = Modifier.height(10.dp))
            Title("${movieDetail?.title}")
            Spacer(modifier = Modifier.height(10.dp))
            IconButton(onClick = {movieDetalViewModel.onFavoriteClicked()}) {
                Icon(
                    imageVector =  Icons.Default.Star,
                    contentDescription = "Favorite Button",
                    tint = if(isFavorite) Color.Yellow else Color.LightGray
                )
            }
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Desc("Genre",genreNames )
                    Desc("Tanggal Rilis", movieDetail?.releaseDate)
                    Desc("Negara Asal", movieDetail?.originCountry)
                    Desc("Durasi"," ${ movieDetail?.runtime } menit")
                    Desc("Status", movieDetail?.status)
                    Desc("Popularitas", movieDetail?.popularity)
                    Desc("Rata-rata Vote", movieDetail?.voteAverage)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ){
                Column(modifier = Modifier.padding(24.dp)) {
                    Text(
                        text = "Overview:",
                        fontWeight = FontWeight.W600,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "${movieDetail?.overview}",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Justify,
                        lineHeight = MaterialTheme.typography.labelLarge.fontSize * 1.5
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
//            Spacer(modifier = Modifier.height(10.dp))
        }
        ButtonNav("Kembali", navController)
    }
}
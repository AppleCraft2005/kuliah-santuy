package com.android.modul5.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.android.modul5.components.ButtonNav
import com.android.modul5.components.Desc
import com.android.modul5.components.Image
import com.android.modul5.components.MovieCard
import com.android.modul5.components.TopBar
import com.android.modul5.viewmodel.MovieViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieDetailScreen(movieId: Int, movieViewModel: MovieViewModel, navController: NavController) {
    val movieDetail by movieViewModel.selectedMovieDetail.collectAsState()
    val errMsg by movieViewModel.errorMsg.collectAsState()

    LaunchedEffect(movieId) {
        movieViewModel.fetchMoviebyDetailbyID(movieId)
    }

    Scaffold(
        topBar = { TopBar( Title = movieDetail?.title ?: "Detail Film") }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            errMsg?.let {msg -> Text(msg) }
            Box(
                modifier = Modifier
                    .width(780.dp)
                    .height(300.dp)
            ) {
                Image(movieDetail?.poster_path)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Desc("Tanggal Rilis", movieDetail?.release_date)
            movieDetail?.genre_ids?.forEach { g ->
                Text("hmm: ${g}")
            }
            Desc("Genre", movieDetail?.genre_ids)
            Desc("Popularitas", movieDetail?.popularity)
            Desc("Rata-rata Vote", movieDetail?.vote_average)
            Spacer(modifier = Modifier.height(10.dp))
            Text("${movieDetail?.overview}", textAlign = TextAlign.Justify)
            Spacer(modifier = Modifier.height(10.dp))
            ButtonNav("Kembali", navController)

        }
    }
}
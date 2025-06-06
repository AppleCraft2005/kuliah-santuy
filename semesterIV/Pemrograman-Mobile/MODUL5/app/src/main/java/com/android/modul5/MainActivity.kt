package com.android.modul5

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.edit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.android.modul5.data.Movie
import com.android.modul5.screens.MovieDetailScreen
import com.android.modul5.ui.theme.MODUL5Theme
import com.android.modul5.viewmodel.DarkModeViewMOdel
import com.android.modul5.viewmodel.MovieViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import displayMovies

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val DarkModeViewMOdel: DarkModeViewMOdel = viewModel()
            val isDarkMode by DarkModeViewMOdel.isDarkMode.collectAsState()

            MODUL5Theme(darkTheme = isDarkMode) {
                NavMovies()
            }
        }
    }
}

@Composable
fun NavMovies() {
    val navController = rememberNavController()
    val movieViewModel: MovieViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "movie_list",
        enterTransition = { // Transisi masuk untuk destinasi baru
            slideInHorizontally(initialOffsetX = { it })  // Masuk dari kanan
        },
        exitTransition = { // Transisi keluar untuk destinasi lama saat yang baru masuk
            slideOutHorizontally(targetOffsetX = { -it })  // Keluar ke kiri
        },
        popEnterTransition = { // Transisi masuk untuk destinasi saat pop (misal, tombol kembali)
            slideInHorizontally(initialOffsetX = { -it })  // Masuk dari kiri
        },
        popExitTransition = { // Transisi keluar untuk destinasi saat pop
            slideOutHorizontally(targetOffsetX = { it })  // Keluar ke kanan
        }
    ) {
        composable("movie_list") {
            displayMovies(movieViewModel, navController)
        }
        composable(
            route = "movie_detail/{movieId}",
            arguments = listOf(
                navArgument("movieId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt("movieId")
            if (movieId != null) {
                MovieDetailScreen(movieId, movieViewModel, navController)
            }
            else {
                Text("Film tidak ditemukan!")
            }
        }
    }
}








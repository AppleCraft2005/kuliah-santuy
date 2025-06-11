package com.android.modul5

import MovieListScreen
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.edit
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.android.modul5.presentation.screens.MovieDetailScreen
import com.android.modul5.presentation.ui.theme.MODUL5Theme
import com.android.modul5.presentation.viewmodel.MovieViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context = LocalContext.current
            val prefs = remember {context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)}
            var isDarkMode by remember { mutableStateOf(prefs.getBoolean("is_dark_mode", false)) }

            MODUL5Theme(darkTheme = isDarkMode) {
                NavMovies(
                    isDarkMode = isDarkMode,
                    onToggle = { newValue ->
                        isDarkMode = newValue
                        prefs.edit { putBoolean("is_dark_mode", newValue) }
                    })
            }
        }
    }
}

@Composable
fun NavMovies(isDarkMode: Boolean, onToggle: (Boolean) -> Unit) {
    val navController = rememberNavController()
    val movieViewModel: MovieViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "movie_list",
        enterTransition = {
            slideInHorizontally(initialOffsetX = { it })
        },
        exitTransition = {
            slideOutHorizontally(targetOffsetX = { -it })
        },
        popEnterTransition = {
            slideInHorizontally(initialOffsetX = { -it })
        },
        popExitTransition = {
            slideOutHorizontally(targetOffsetX = { it })
        }
    ) {
        composable("movie_list") {
            MovieListScreen(movieViewModel, navController, isDarkMode = isDarkMode, onToggle = onToggle)
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








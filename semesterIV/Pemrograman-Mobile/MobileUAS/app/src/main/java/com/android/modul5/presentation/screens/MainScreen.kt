package com.android.modul5.presentation.screens

import MovieListScreen
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.android.modul5.presentation.components.BottomNavigationBar
import com.android.modul5.presentation.components.TopBar
import com.android.modul5.presentation.navigation.BottomNavigationItem
import com.android.modul5.presentation.viewmodel.MovieDetailViewModel
import com.android.modul5.presentation.viewmodel.MovieViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavMovies(isDarkMode: Boolean, onToggle: (Boolean) -> Unit) {
    val navController = rememberNavController()
    val movieViewModel: MovieViewModel = koinViewModel()
    val movieDetailViewModel: MovieDetailViewModel = koinViewModel()
    val navItems = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Search,
        BottomNavigationItem.Favourite,
        BottomNavigationItem.About
    )

    Scaffold(
        topBar = { TopBar("SIMOVIE") },
        bottomBar = {
            BottomNavigationBar(navController = navController, navItems = navItems)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavigationItem.Home.route,
            modifier = Modifier.padding(innerPadding),
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
            composable(BottomNavigationItem.Home.route) {
                MovieListScreen(movieViewModel, navController)
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
                    MovieDetailScreen(movieId, movieDetailViewModel, navController)
                }
                else {
                    Text("Film tidak ditemukan!")
                }
            }
            composable(BottomNavigationItem.Search.route) {
                MovieSearchScreen(navController = navController)
            }
            composable(BottomNavigationItem.Favourite.route) {
                FavouriteMovieScreen(navController = navController)
            }
            composable(BottomNavigationItem.About.route) {
                AboutScreen(isDarkMode = isDarkMode, onToggle = onToggle)
            }
        }
    }
}
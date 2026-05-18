package com.android.modul5.presentation.screens

import MovieListScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.android.modul5.presentation.components.TopBottomBar.BottomNavigationBar
import com.android.modul5.presentation.components.TopBottomBar.TopBar
import com.android.modul5.presentation.navigation.BottomNavigationItem
import com.android.modul5.presentation.viewmodel.FavoriteMovieViewModel
import com.android.modul5.presentation.viewmodel.MovieDetailViewModel
import com.android.modul5.presentation.viewmodel.MovieSearchViewModel
import com.android.modul5.presentation.viewmodel.MovieViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavMovies(isDarkMode: Boolean, onToggle: (Boolean) -> Unit) {
    val navController = rememberNavController()
    val movieViewModel: MovieViewModel = koinViewModel()
    val movieDetailViewModel: MovieDetailViewModel = koinViewModel()
    val movieSearchViewModel: MovieSearchViewModel = koinViewModel()
    val favoriteMovieViewModel: FavoriteMovieViewModel = koinViewModel()
    val navItems = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Search,
        BottomNavigationItem.Favourite,
        BottomNavigationItem.About
    )

    Scaffold(
        topBar = { TopBar("MovieLens") },
        bottomBar = {
            BottomNavigationBar(navController = navController, navItems = navItems)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavigationItem.Home.route,
            modifier = Modifier.padding(innerPadding),
        ) {
            composable(BottomNavigationItem.Home.route) {
                MovieListScreen(movieViewModel = movieViewModel, navController = navController)
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
                    MovieDetailScreen(movieId = movieId, movieDetalViewModel = movieDetailViewModel, navController = navController)
                }
                else {
                    Text("Film tidak ditemukan!")
                }
            }
            composable(BottomNavigationItem.Search.route) {
                MovieSearchScreen(searchViewModel =  movieSearchViewModel, navController = navController)
            }
            composable(BottomNavigationItem.Favourite.route) {
                FavouriteMovieScreen(favoriteMovieViewModel = favoriteMovieViewModel, navController = navController)
            }
            composable(BottomNavigationItem.About.route) {
                AboutScreen(isDarkMode = isDarkMode, onToggle = onToggle)
            }
        }
    }
}
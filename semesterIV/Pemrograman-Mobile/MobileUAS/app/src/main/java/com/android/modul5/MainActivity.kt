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
import com.android.modul5.data.local.MovieDatabase
import com.android.modul5.data.remote.RetrofitClient
import com.android.modul5.data.repository.MovieRepositoryImpl
import com.android.modul5.domain.repository.MovieRepository
import com.android.modul5.domain.usecase.AddFavMovieUseCase
import com.android.modul5.domain.usecase.CheckFavMovieUseCase
import com.android.modul5.domain.usecase.GetFavoriteMoviesUseCase
import com.android.modul5.domain.usecase.GetMovieDetailUseCase
import com.android.modul5.domain.usecase.GetPopularMoviesUseCase
import com.android.modul5.domain.usecase.RemoveFavMovieUseCase
import com.android.modul5.domain.usecase.SearchMoviesUseCase
import com.android.modul5.presentation.navigation.BottomNavigationItem
import com.android.modul5.presentation.screens.AboutScreen
import com.android.modul5.presentation.screens.FavouriteMovieScreen
import com.android.modul5.presentation.screens.MovieDetailScreen
import com.android.modul5.presentation.screens.MovieSearchScreen
import com.android.modul5.presentation.screens.NavMovies
import com.android.modul5.presentation.ui.theme.MODUL5Theme
import com.android.modul5.presentation.viewmodel.FavoriteMovieViewModel
import com.android.modul5.presentation.viewmodel.MovieDetailViewModel
import com.android.modul5.presentation.viewmodel.MovieSearchViewModel
import com.android.modul5.presentation.viewmodel.MovieViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

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












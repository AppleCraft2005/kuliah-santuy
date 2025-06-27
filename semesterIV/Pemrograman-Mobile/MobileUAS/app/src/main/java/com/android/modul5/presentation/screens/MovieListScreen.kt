import android.icu.text.CaseMap.Title
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.android.modul5.presentation.components.MovieCard
import com.android.modul5.presentation.components.TopBar
import com.android.modul5.presentation.viewmodel.MovieViewModel
import com.android.modul5.presentation.components.DarkModeSwitch
import com.android.modul5.presentation.components.Title
import com.android.modul5.presentation.components.TitleFirst
import com.android.modul5.presentation.components.noInternetAnimate

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MovieListScreen(movieViewModel: MovieViewModel, navController: NavController) {
    val Movies by movieViewModel.Movies.collectAsState()
    val IndonesiaMovies by movieViewModel.IndonesiaMovies.collectAsState()
    val AnimeMovies by movieViewModel.AnimeMovies.collectAsState()
    val errMsg by movieViewModel.errorMsg.collectAsState()
    val isLoading by movieViewModel.isLoading.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Yellow)
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
            Button(onClick = { movieViewModel.fetchMovies() }) {
                Text("Retry")
            }
        }
        else if(isLoading) {
            CircularProgressIndicator(modifier = Modifier.padding(16.dp))
        }
        else {
            TitleFirst("Popular Films")
            LazyRow {
                items(Movies.size) {movie ->
                    MovieCard(movieItem = Movies[movie], navController = navController)
                }
            }
            TitleFirst("Indonesia Films")
            LazyRow {
                items(IndonesiaMovies.size) {movie ->
                    MovieCard(movieItem = IndonesiaMovies[movie], navController = navController)
                }
            }
            TitleFirst("Cartoon Films")
            LazyRow {
                items(AnimeMovies.size) {movie ->
                    MovieCard(movieItem = AnimeMovies[movie], navController = navController)
                }
            }
        }
    }
}




import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.android.modul5.presentation.components.Card.MovieCard
import com.android.modul5.presentation.viewmodel.MovieViewModel
import com.android.modul5.presentation.components.Text.TitleFirst
import com.android.modul5.presentation.components.LottieAnimation.noInternetAnimate

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
            .padding(horizontal = 16.dp)
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
            Column {
                TitleFirst("Popular 🔥")
                LazyRow(
                    modifier = Modifier.height(385.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    items(Movies.size) {movie ->
                        MovieCard(movieItem = Movies[movie], navController = navController)
                    }
                }
                TitleFirst("Indonesia \uD83C\uDDEE\uD83C\uDDE9")
                LazyRow(
                    modifier = Modifier.height(385.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    items(IndonesiaMovies.size) {movie ->
                        MovieCard(movieItem = IndonesiaMovies[movie], navController = navController)
                    }
                }
                TitleFirst("Anime \uD83C\uDF38")
                LazyRow(
                    modifier = Modifier.height(385.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    items(AnimeMovies.size) {movie ->
                        MovieCard(movieItem = AnimeMovies[movie], navController = navController)
                    }
                }
            }
        }
    }
}




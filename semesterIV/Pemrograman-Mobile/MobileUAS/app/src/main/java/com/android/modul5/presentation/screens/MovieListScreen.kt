import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.android.modul5.presentation.components.MovieCard
import com.android.modul5.presentation.components.TopBar
import com.android.modul5.presentation.viewmodel.MovieViewModel
import com.android.modul5.presentation.components.DarkModeSwitch
import com.android.modul5.presentation.components.Title

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MovieListScreen(movieViewModel: MovieViewModel, navController: NavController) {
    val Movies by movieViewModel.Movies.collectAsState()
    val errMsg by movieViewModel.errorMsg.collectAsState()
    val isLoading by movieViewModel.isLoading.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Title("Popular Films")
        errMsg?.let {msg -> Text(msg) }
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.padding(16.dp))
        }
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 150.dp),
            modifier = Modifier.fillMaxWidth(),
//            contentPadding = PaddingValues(8.dp),
//            horizontalArrangement = Arrangement.spacedBy(8.dp),
//            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(Movies) {movie ->
                MovieCard(movieItem = movie, navController = navController)
            }
        }
    }
}

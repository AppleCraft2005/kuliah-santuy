import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.android.modul5.presentation.components.MovieCard
import com.android.modul5.presentation.components.TopBar
import com.android.modul5.presentation.viewmodel.MovieViewModel
import com.android.modul5.presentation.components.DarkModeSwitch

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MovieListScreen(movieViewModel: MovieViewModel, navController: NavController, isDarkMode: Boolean, onToggle: (Boolean) -> Unit) {
    val Movies by movieViewModel.Movies.collectAsState()
    val errMsg by movieViewModel.errorMsg.collectAsState()

    Scaffold(
        topBar = { TopBar("SIMOVIE") }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
        ) {
            DarkModeSwitch(isDarkMode = isDarkMode, onToggle = onToggle)

            errMsg?.let {msg -> Text(msg) }
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Movies.forEach { movie ->
                    MovieCard(movieItem = movie, navController)
                }
            }
        }
    }
}

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.android.modul5.presentation.components.MovieCard
import com.android.modul5.presentation.components.TopBar
import com.android.modul5.viewmodel.MovieViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.content.edit
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.media3.common.util.Log
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

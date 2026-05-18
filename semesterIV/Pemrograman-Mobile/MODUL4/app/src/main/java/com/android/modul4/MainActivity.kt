package com.android.modul4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.modul4.data.sourceData
import com.android.modul4.screens.CardList
import com.android.modul4.screens.DetailPage
import com.android.modul4.ui.theme.Modul4Theme
import com.android.modul4.viewmodel.CardViewModel
import com.android.modul4.viewmodel.CardViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Modul4Theme {
                Display()
            }
        }
    }
}

@Composable
fun Display() {
    val navController = rememberNavController()
    val viewModelFactory = CardViewModelFactory(sourceData())
    val viewModel: CardViewModel = viewModel(factory = viewModelFactory)

    Scaffold() { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "card_list",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("card_list") {
                CardList(navController, viewModel)
            }
            composable("detail/{itemTitle}") { backStackEntry ->
                val itemTitle = backStackEntry.arguments?.getString("itemTitle")!!
                DetailPage(itemTitle, navController, viewModel)
            }
        }
    }
}


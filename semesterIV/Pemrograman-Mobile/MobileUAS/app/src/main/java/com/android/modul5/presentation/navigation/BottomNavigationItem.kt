package com.android.modul5.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationItem(val route: String, val label: String, val Icon:ImageVector) {
    object Home: BottomNavigationItem("movie_screen", "Home", Icons.Filled.Home)
    object Search: BottomNavigationItem("search_screen", "Search", Icons.Filled.Search)
    object Favourite: BottomNavigationItem("favourite_screen", "Favourite", Icons.Filled.Star)
    object About: BottomNavigationItem("about_screen", "About", Icons.Filled.AccountCircle)
}

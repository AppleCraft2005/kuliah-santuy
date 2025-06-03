package com.android.cobacoba

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

data class NavItem(
    val label: String,
    val icon: ImageVector
)

val listNavItems = listOf(
    NavItem("Tombol", Icons.Default.Warning),
    NavItem("Chatbot", Icons.Default.Email),
    NavItem("Peta", Icons.Default.Place),
    NavItem("Statistik", Icons.Default.Create),
    NavItem("Profile", Icons.Default.Person)
)


@Composable
fun BottomBar() {
    var selectedNavItem by remember { mutableStateOf(0) }
    BottomAppBar(containerColor = Color.Transparent){
        NavigationBar(containerColor = Color.Transparent) {
            listNavItems.forEachIndexed{ index,  item ->
                NavigationBarItem(
                    selected = selectedNavItem == index,
                    onClick = { selectedNavItem = index },
                    icon = { Icon(imageVector = item.icon, contentDescription = "icon") },
                    label = { Text(item.label)  },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        selectedTextColor = MaterialTheme.colorScheme.primary,
                        indicatorColor = Color.Transparent
                    )
                )
            }
        }
    }

}

@Composable
@Preview
fun botbar() {
    BottomBar()
}
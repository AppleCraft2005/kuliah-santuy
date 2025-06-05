package com.android.modul5.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun Button(action: String, navController: NavController) {
    Button(onClick = {
        navController.popBackStack()
    }) { Text("Kembali") }

    androidx.compose.material3.Button(onClick = {
        navController.navigate("movie_detail/${movieItem.id}")
    }) { Text(text = "Detail") }
}
package com.android.modul5.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ButtonNav(action: String, navController: NavController, movieId: Int = 0) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = {
                if (action == "Detail") {navController.navigate("movie_detail/${movieId}")}
                else {navController.popBackStack()}
            },
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.width(100.dp).height(35.dp)
        ) {
            Text(action, color = MaterialTheme.colorScheme.tertiary)
        }
    }

}
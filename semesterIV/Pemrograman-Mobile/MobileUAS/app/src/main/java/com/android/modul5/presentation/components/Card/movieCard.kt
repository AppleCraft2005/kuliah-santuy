package com.android.modul5.presentation.components.Card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.android.modul5.domain.model.Movie
import com.android.modul5.presentation.components.Glide.Glide
import com.android.modul5.presentation.components.Text.TitleSecond

@Composable
fun MovieCard(movieItem: Movie, navController: NavController) {
    Card(
        modifier = Modifier
            .width(210.dp)
            .fillMaxHeight()
            .clickable {
                navController.navigate("movie_detail/${movieItem.id}")
            },
        shape = MaterialTheme.shapes.small,
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        Glide(movieItem.posterPath)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            TitleSecond(movieItem.title)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(movieItem.releaseDate)
                Text(movieItem.originalLanguage)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}


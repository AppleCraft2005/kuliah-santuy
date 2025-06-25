package com.android.modul5.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.android.modul5.domain.model.Movie

@Composable
fun MovieCard(movieItem: Movie, navController: NavController) {
    Card(
       modifier = Modifier
           .width(180.dp)
           .padding(8.dp),
        shape = MaterialTheme.shapes.small,
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
        ) {
        Glide(movieItem.posterPath)
        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
            Text(text = movieItem.title, fontWeight = FontWeight.W600, lineHeight = 17.sp, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            Text("Rating = ${ movieItem.voteAverage }/10")
        }
        Spacer(modifier = Modifier.height(15.dp))
        ButtonNav("Detail", navController, movieItem.id)
        Spacer(modifier = Modifier.height(10.dp))
    }
}
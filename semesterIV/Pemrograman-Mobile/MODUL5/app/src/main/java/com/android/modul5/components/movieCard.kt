package com.android.modul5.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.android.modul5.data.Movie
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieCard(movieItem: Movie, navController: NavController) {
    Card(
       modifier = Modifier
           .width(180.dp)
           .padding(8.dp),
        shape = MaterialTheme.shapes.small,
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
        ) {
        Image(movieItem.poster_path)

        Text(text = movieItem.title, fontWeight = FontWeight.W600, lineHeight = 17.sp, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(15.dp))
        Column(modifier =Modifier.padding(horizontal = 8.dp)) {
            Text(text = "Asal Negara: ${movieItem.original_language}", fontSize = 14.sp)
            Text(text = "Tanggal Rilis: ${movieItem.release_date}", fontSize = 14.sp)
        }
        Spacer(modifier = Modifier.height(15.dp))
        ButtonNav("Detail", navController, movieItem.id)
        Spacer(modifier = Modifier.height(10.dp))

    }
}
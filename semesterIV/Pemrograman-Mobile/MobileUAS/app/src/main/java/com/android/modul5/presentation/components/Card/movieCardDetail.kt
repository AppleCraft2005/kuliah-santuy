package com.android.modul5.presentation.components.Card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.android.modul5.domain.model.MovieDetail
import com.android.modul5.presentation.components.Glide.Glide
import com.android.modul5.presentation.components.Text.MovieData
import com.android.modul5.presentation.components.Text.TitleSecond

@Composable
fun MovieCardDetail(movieItem: MovieDetail, onFavClick: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.small,
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        Glide(movieItem.posterPath)
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(12.dp))
            TitleSecond(movieItem.title)
            IconButton(onClick = {onFavClick(movieItem.id)}) {
                Icon(
                    imageVector =  Icons.Default.Star,
                    contentDescription = "Favorite Button",
                    tint = Color.Yellow
                )
            }
            MovieData("Genre", movieItem.genre.map { it.name }.joinToString())
            Row {
                Column(modifier = Modifier.weight(1f)) {
                    MovieData("Release Date", movieItem.releaseDate)
                    MovieData("Origin Country", movieItem.originCountry.joinToString())
                    MovieData("Duration"," ${ movieItem.runtime } menit")
                    MovieData("Status", movieItem.status)
                    MovieData("Popularity", "%.2f".format(movieItem.popularity) )
                    MovieData("Vote Average", "%.2f".format(movieItem.voteAverage))
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Overview:",
                        fontWeight = FontWeight.W600,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = movieItem.overview,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Justify,
                        lineHeight = MaterialTheme.typography.labelLarge.fontSize * 1.5,
                        maxLines = 15,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
    }
}
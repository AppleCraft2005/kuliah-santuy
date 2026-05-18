package com.android.modul5.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Desc(title: String, content: Any?) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "$title:",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.W600,
            textAlign = TextAlign.Start,
        )
        Text(
            text = content.toString(),
            style = MaterialTheme.typography.bodyMedium
        )
    }
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun Title(title: String) {
    Text(
        text = title,
        fontWeight = FontWeight.W600,
        style = MaterialTheme.typography.titleLarge
    )
}

@Composable
fun TitleFirst(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.W600
    )
}

@Composable
fun TitleSecond(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.W600,
        modifier = Modifier.padding(bottom = 12.dp)
    )
}
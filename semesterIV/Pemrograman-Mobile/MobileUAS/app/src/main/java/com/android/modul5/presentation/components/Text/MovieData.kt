package com.android.modul5.presentation.components.Text

import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun MovieData(title: String, content: Any?) {
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




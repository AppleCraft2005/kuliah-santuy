package com.android.modul5.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@Composable
fun Desc(title: String, content: Any?) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "$title = ",
            fontWeight = FontWeight.W600,
            textAlign = TextAlign.Start
            )
        Text(content.toString())
    }
}
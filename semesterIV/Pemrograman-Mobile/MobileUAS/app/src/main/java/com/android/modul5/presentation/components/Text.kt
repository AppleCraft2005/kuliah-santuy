package com.android.modul5.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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

@Composable
fun Title(title: String) {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.W600,
        fontSize = 23.sp
    )
}
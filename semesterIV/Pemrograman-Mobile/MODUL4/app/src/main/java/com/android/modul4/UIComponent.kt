package com.android.modul4

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@Composable
fun Desc(desc: String) {
    Text(
        text = desc,
        fontSize = 14.sp,
        textAlign = TextAlign.Justify
    )
}
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Img(url: String, width: Int) {
    GlideImage(
        model = url,
        contentDescription = "My Image",
        modifier = Modifier
            .width(width.dp)
            .padding(6.dp)
            .clip(RoundedCornerShape(6.dp)),
    )
}
@Composable
fun Title(title: String) {
    Text(
        text = title,
        fontSize = 18.sp,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun DetailRow(label:String, value:String) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(
            text = label,
            modifier = Modifier.width(150.dp),
            fontWeight = FontWeight.SemiBold
        )
        Text(value)
    }
}


package com.android.modul5.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.android.modul5.R
import com.android.modul5.presentation.components.DarkModeSwitch
import com.android.modul5.presentation.components.Title

@Composable
fun AboutScreen(isDarkMode: Boolean, onToggle: (Boolean) -> Unit) {
    Column(
        Modifier.verticalScroll(rememberScrollState())
    ) {
        Title("Tentang Pengembang")
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.myimg2),
                contentDescription = "my img",
                modifier = Modifier
                    .width(360.dp)
                    .clip(RoundedCornerShape(7.dp)),
            )
        }

        Column(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 15.dp)
        ) {
            Text("Nama : Jovan Gilbert Natamasindah")
            Text("NIM : 2310817310002")
            Spacer(modifier = Modifier.height(5.dp))
            Text("Seorang Mahasiswa Semester 4 yang sedang mengerjakan aplikasi ini untuk memenuhi Ujian Akhir Semester mata kuliah Pemrograman Mobile", textAlign = TextAlign.Justify)
        }

        Title("Setting")
        DarkModeSwitch(isDarkMode = isDarkMode, onToggle = onToggle)

    }
}
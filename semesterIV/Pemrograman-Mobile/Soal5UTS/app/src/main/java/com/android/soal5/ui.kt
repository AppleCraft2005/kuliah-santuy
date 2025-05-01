package com.android.soal5

import android.provider.ContactsContract.CommonDataKinds.Organization
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BiografiDesc(desc: String) {
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = desc,
        fontSize = 15.sp,
        textAlign = TextAlign.Justify
    )
}

@Composable
fun OrganizationStyle(Img: Int, judul: String, tanggal: String) {
    Column {
        Image(
            painter = painterResource(id = Img),
            contentDescription = judul,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(judul, fontWeight = FontWeight.SemiBold)
        Text(tanggal)
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun Title(title: String) {
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = title,
        fontSize = 18.sp,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun DataRow(label: String, value: String) {
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
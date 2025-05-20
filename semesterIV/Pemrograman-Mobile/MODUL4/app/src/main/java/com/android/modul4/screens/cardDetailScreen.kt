package com.android.modul4.screens

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.android.modul4.Desc
import com.android.modul4.DetailRow
import com.android.modul4.Img
import com.android.modul4.Title
import com.android.modul4.viewmodel.CardViewModel

@Composable
fun DetailPage(itemTitle: String, navController: NavController, viewModel: CardViewModel) {
    val context = LocalContext.current
    val detailMaskapai = viewModel.getDetailByTitle(itemTitle)

    if (detailMaskapai != null) {
        Column(modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Img(detailMaskapai.ImageURL, 400)
            Title(itemTitle)
            Spacer(modifier = Modifier.height(16.dp))
            detailMaskapai?.let {
                DetailRow("Tanggal Berdiri", ": ${it.tglBerdiri}")
                DetailRow("Armada", ": ${it.armada}")
                DetailRow("Rute Tujuan", ": ${it.rute} ")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Desc(detailMaskapai.desc)
            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {
                Button(onClick = {
                    Log.d("Detail", "tombol website ${itemTitle} ditekan")
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(detailMaskapai?.let {it.website}))
                    context.startActivity(intent)
                }, modifier = Modifier.padding(horizontal = 6.dp),
                    shape = RoundedCornerShape(8.dp)
                ) { Text("Web $itemTitle") }
                Button(onClick = {
                    navController.navigate("card_list") }, shape = RoundedCornerShape(8.dp)) { Text("Kembali") }
            }
        }
    }
    else {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Data tidak ditemukan untuk \"$itemTitle\"")
            Button(onClick = { navController.navigate("card_list") }) {
                Text("Kembali")
            }
        }
    }
}

package com.android.modul4.screens

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.android.modul4.Desc
import com.android.modul4.Img
import com.android.modul4.Title
import com.android.modul4.viewmodel.CardViewModel

@Composable
fun CardList( navController: NavController, viewModel: CardViewModel) {
    val CardList by viewModel.cardList.collectAsState()
    val context = LocalContext.current
    val bgcard = Color(0xFF7AE2CF)
    val bgcolor = Color(0xFFFFFDF6)

    Title("Maskapai-maskapai Penerbangan di Indonesia")
    LazyColumn(
        modifier = Modifier
            .padding(top = 50.dp)
            .background(bgcolor)
    ){
        items(CardList.size) { index ->
            val property = CardList[index]
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp)
                    .height(200.dp),
                colors = CardDefaults.cardColors(containerColor = bgcard),
            ) {
                Row(
                    modifier = Modifier
                        .padding(6.dp),
                ) {
                    Img(property.ImageURL, 180)
                    Column {
                        Title(property.title)
                        Desc(if(property.desc.length > 80) property.desc.take(80) + "..." else property.desc)
                        Spacer(modifier = Modifier.weight(1f))
                        Row(
                            horizontalArrangement = Arrangement.End,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Button(onClick = {
                                viewModel.selectCard(property, "wiki")
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(property.Wiki))
                                context.startActivity(intent)
                            }, modifier = Modifier.padding(horizontal = 6.dp),
                                shape = RoundedCornerShape(8.dp)
                            ) { Text("Wiki") }
                            Button(onClick = {
                                viewModel.selectCard(property, "Detail")
                                Log.d("cardListScreen","pindah ke halaman detail dari item ${property.title} ")
                                navController.navigate("detail/${property.title}")
                            }, shape = RoundedCornerShape(8.dp)) { Text("Detail") }
                        }
                    }
                }
            }
        }
    }
}

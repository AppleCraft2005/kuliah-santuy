package com.android.modul3

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.modul3.ui.theme.Modul3Theme
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Modul3Theme {
                val navController = rememberNavController()
                Display(navController)
            }
        }
    }
}

@Composable
fun Display(navController: NavHostController) {
    Scaffold(topBar = { TopBar() }) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "card_list",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("card_list") {
                CardList(navController)
            }
            composable("detail/{itemTitle}/{itemDesc}/{itemImageURL}") { backStackEntry ->
                val itemTitle = backStackEntry.arguments?.getString("itemTitle")!!
                val itemDesc = backStackEntry.arguments?.getString("itemDesc")!!
                val itemImageURL = backStackEntry.arguments?.getString("itemImageURL")!!
                DetailPage(itemTitle, itemDesc, itemImageURL)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class) // agar bisa menggunakan topappbar yang bersifat exprerimental
@Composable
fun TopBar( ) {
    TopAppBar(
        title = { Text("Tip Time") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.purple_500),
            titleContentColor = colorResource(id = R.color.white)
        ),
        modifier = Modifier
            .statusBarsPadding() // menghilangkan padding otomatis untuk menghindari tabrakan dengan status bar
    )
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CardList( navController: NavController) {

    data class cardProperty(
        val title: String,
        val desc: String,
        val ImageURL: String
    )

    val cardProperties = listOf(
        cardProperty(
            title = "Garuda Indonesia",
            desc = "Garuda Indonesia adalah maskapai penerbangan nasional Indonesia yang didirikan pada tahun 1949. Berbasis di Jakarta, Garuda dikenal dengan layanan penerbangannya yang berkualitas tinggi dan keramahannya, mencerminkan budaya Indonesia. Maskapai ini mengoperasikan penerbangan domestik dan internasional ke berbagai tujuan di Asia, Australia, Eropa, dan Timur Tengah. Garuda Indonesia juga merupakan anggota dari aliansi penerbangan global SkyTeam dan telah beberapa kali meraih penghargaan dunia atas pelayanan kabinnya.",
            ImageURL = "https://cdn.plnspttrs.net/11964/pk-gib-garuda-indonesia-mcdonnell-douglas-dc-10-30_PlanespottersNet_714188_a594861cb0_o.jpg"
        ),
        cardProperty(
            title = "Lion Air",
            desc = "Lion Air adalah maskapai penerbangan swasta terbesar di Indonesia yang berdiri pada tahun 1999. Fokus utamanya adalah layanan penerbangan berbiaya rendah (low-cost carrier) dengan rute domestik dan internasional. Lion Air terkenal dengan jaringan penerbangan yang luas dan harga tiket yang kompetitif.",
            ImageURL = "https://cdn.plnspttrs.net/20446/pk-lhg-lion-air-boeing-747-412_PlanespottersNet_612707_2702071c86_o.jpg"
        ),
        cardProperty(
            title = "Citilink",
            desc = "Citilink adalah anak perusahaan dari Garuda Indonesia yang beroperasi sebagai maskapai berbiaya rendah. Didirikan pada tahun 2001, Citilink menawarkan penerbangan domestik dan regional dengan konsep layanan yang modern, dinamis, dan lebih santai untuk menarik kalangan muda dan pelancong bisnis.",
            ImageURL = "https://cdn.plnspttrs.net/42179/pk-gaf-citilink-atr-72-600-72-212a_PlanespottersNet_1657140_83de625cfa_o.jpg"
        ),
        cardProperty(
            title = "Super Air Jet",
            desc = "Super Air Jet adalah maskapai baru di Indonesia yang mulai beroperasi pada tahun 2021. Mengusung konsep \"new lifestyle airline\", Super Air Jet fokus melayani segmen anak muda dengan harga terjangkau, desain modern, dan rute-rute domestik populer.",
            ImageURL = "https://cdn.plnspttrs.net/14570/pk-std-super-air-jet-airbus-a320-232-wl_PlanespottersNet_1755960_137445c980_o.jpg"
        ),
        cardProperty(
            title = "Batik Air",
            desc = "Batik Air adalah maskapai layanan penuh (full-service) dari Lion Air Group yang didirikan pada tahun 2013. Batik Air menawarkan fasilitas premium seperti makanan dalam penerbangan dan hiburan di kursi, serta menghubungkan berbagai kota besar di Indonesia dan Asia.",
            ImageURL = "https://cdn.plnspttrs.net/35032/pk-lug-batik-air-airbus-a320-214-wl_PlanespottersNet_1693958_5bbffba586_o.jpg"
        ),
        cardProperty(
            title = "Pelita Air",
            desc = "Pelita Air adalah maskapai yang awalnya fokus pada penerbangan carter dan layanan energi (minyak dan gas), namun sejak 2022 mulai mengembangkan penerbangan reguler domestik. Sebagai anak usaha Pertamina, Pelita Air membawa konsep layanan penerbangan yang nyaman dan profesional.",
            ImageURL = "https://cdn.plnspttrs.net/22490/pk-pwd-pelita-air-service-airbus-a320-214-wl_PlanespottersNet_1698319_901e5c6a31_o.jpg"
        )
    )
    LazyColumn {
        items(cardProperties.size) {index ->
            val property = cardProperties[index]
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Cyan),
            ) {
                Row(
                    modifier = Modifier
                        .padding(6.dp),
                ) {
                    GlideImage(
                        model = property.ImageURL,
                        contentDescription = "My Image",
                        modifier = Modifier
                            .width(150.dp)
                            .padding(6.dp)
                            .clip(RoundedCornerShape(6.dp))
                    )
                    Column {
                        Text(property.title)
                        Text(
                            text = if(property.desc.length > 80) property.desc.take(80) + "..." else property.desc
                        )
                        Row(
                            horizontalArrangement = Arrangement.End,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Button(onClick = {}, modifier = Modifier.padding(horizontal = 6.dp)) {Text("Wiki")  }
                            Button(onClick = {
                                navController.navigate("detail/${property.title}/${property.desc}/${Uri.encode(property.ImageURL)}")
                            }) {Text("Detail") }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailPage(itemTitle: String, itemDesc:String, itemImageURL:String) {
    Scaffold { innerPadding ->
        Column(modifier = Modifier
                .padding(innerPadding)
        ) {
            GlideImage(
                model = itemImageURL,
                contentDescription = "My Image",
                modifier = Modifier
                    .size(400.dp)
                    .clip(RoundedCornerShape(6.dp))
            )
            Text("Halaman Detail dari $itemTitle")
            Text(itemDesc)
        }
    }
}


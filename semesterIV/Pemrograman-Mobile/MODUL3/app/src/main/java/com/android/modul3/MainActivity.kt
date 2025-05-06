package com.android.modul3

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
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
    Scaffold() { innerPadding ->
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

//@OptIn(ExperimentalMaterial3Api::class) // agar bisa menggunakan topappbar yang bersifat exprerimental
//@Composable
//fun TopBar( ) {
//    TopAppBar(
//        title = { Text("Maskapai-Maskapai Penerbangan di Indonesia") },
//        colors = TopAppBarDefaults.topAppBarColors(
//            containerColor = colorResource(id = R.color.purple_500),
//            titleContentColor = colorResource(id = R.color.white)
//        ),
//        modifier = Modifier
//            .statusBarsPadding() // menghilangkan padding otomatis untuk menghindari tabrakan dengan status bar
//    )
//}
val bgcard = Color(0xFF7AE2CF)
val bgcolor = Color(0xFFF5EEDD)
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CardList( navController: NavController) {
    val context = LocalContext.current

    Title("Maskapai-maskapai Penerbangan di Indonesia")
    LazyColumn(modifier = Modifier.padding(top = 24.dp).background(bgcolor)){
        items(cardProperties.size) {index ->
            val property = cardProperties[index]
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
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(property.Wiki))
                                context.startActivity(intent)
                            }, modifier = Modifier.padding(horizontal = 6.dp),
                                shape = RoundedCornerShape(8.dp)
                            ) {Text("Wiki") }
                            Button(onClick = {
                                navController.navigate("detail/${property.title}/${property.desc}/${Uri.encode(property.ImageURL)}")
                            }, shape = RoundedCornerShape(8.dp)) {Text("Detail") }
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
    val context = LocalContext.current
    val namaMaskapai = detailProperties.find{ it.title == itemTitle}
    Column(modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
        ) {
            Img(itemImageURL, 400)
            Title(itemTitle)
            Spacer(modifier = Modifier.height(16.dp))
            namaMaskapai?.let {
                DetailRow("Tanggal Berdiri", ": ${it.tglBerdiri}")
                DetailRow("Armada", ": ${it.armada}")
                DetailRow("Rute Tujuan", ": ${it.rute} ")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Desc(itemDesc)
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(namaMaskapai?.let {it.website}))
                context.startActivity(intent)
            }, modifier = Modifier.padding(horizontal = 6.dp),
                shape = RoundedCornerShape(8.dp)
            ) {Text("Web $itemTitle") }
        }
    }



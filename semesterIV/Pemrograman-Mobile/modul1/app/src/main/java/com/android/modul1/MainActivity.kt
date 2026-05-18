package com.android.modul1

import android.media.Image
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.android.modul1.ui.theme.Modul1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Modul1Theme {
                Display()
            }
        }
    }
}

@Composable
fun Display() {
    Scaffold(topBar = { TopBar() }) { innerPadding ->
        RollDice(modifier = Modifier.padding(innerPadding))
    }
}

@OptIn(ExperimentalMaterial3Api::class) // agar bisa menggunakan topappbar yang bersifat exprerimental
@Composable
fun TopBar( ) {
    TopAppBar(
        title = { Text("Dice Roller") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.blue_dark),
            titleContentColor = colorResource(id = R.color.white)
        ),
        modifier = Modifier
            .statusBarsPadding() // menghilangkan padding otomatis untuk menghindari tabrakan dengan status bar
    )
}

@Composable
fun RollDice(modifier: Modifier = Modifier ) {

    var Dice1 by rememberSaveable { mutableStateOf(0) }
    var Dice2 by rememberSaveable { mutableStateOf(0) }
    val context = LocalContext.current

    val (img1, img2) = diceImg(Dice1, Dice2)
    val Img1 = img1
    val Img2 = img2

    Column(
        modifier = modifier
            .background(colorResource(id = R.color.cream))
            .fillMaxSize(), // agar column memenuhi satu layar hp
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Image(
                painter = painterResource(Img1),
                contentDescription = "Dice 1 image",
                modifier = Modifier
                    .width(150.dp)
            )
            Image(
                painter = painterResource(Img2),
                contentDescription = "Dice 2 image",
                modifier = Modifier
                    .width(150.dp)
            )
        }
        Button(onClick = {
            Dice1 = randomDice()
            Dice2 = randomDice()

            if(Dice1 == Dice2) {Toast.makeText(context, "Selamat anda dapat dadu double!", Toast.LENGTH_SHORT).show()}
            else{Toast.makeText(context, "Anda belum beruntung!", Toast.LENGTH_SHORT).show()}
        },
            colors = ButtonDefaults.buttonColors(
                contentColor = colorResource(id = R.color.white),
                containerColor = colorResource(id = R.color.blue_darker)
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text("ROLL DICE")
        }
    }
}
package com.android.modul2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.modul2.ui.theme.Modul2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Modul2Theme {
                    Display()
            }
        }
    }
}

@Composable
fun Display() {
    Scaffold(topBar = { TopBar() }) { innerPadding ->
        TipCalc(modifier = Modifier.padding(innerPadding))
    }
}

@OptIn(ExperimentalMaterial3Api::class) // agar bisa menggunakan topappbar yang bersifat exprerimental
@Composable
fun TopBar( ) {
    TopAppBar(
        title = { Text("Tip Time") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(id = R.color.hijau_dark),
            titleContentColor = colorResource(id = R.color.white)
        ),
        modifier = Modifier
            .statusBarsPadding() // menghilangkan padding otomatis untuk menghindari tabrakan dengan status bar
    )
}

@OptIn(ExperimentalMaterial3Api::class) // agar bisa menggunakan topappbar yang bersifat exprerimental
@Composable
fun TipCalc(modifier: Modifier = Modifier) {
    var inputNilai by rememberSaveable { mutableStateOf("") }
    var optionSelect by rememberSaveable { mutableStateOf("Amazing") }
    var switchPosition by rememberSaveable { mutableStateOf(true) }
    var hasil by rememberSaveable { mutableStateOf(0.0) }
    val context = LocalContext.current

    Column(
        modifier = modifier
            .background(colorResource(id = R.color.abu))
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 10.dp)
    ) {
        TextField(
            value = inputNilai,
            onValueChange = {inputNilai = it},
            label = { Text("Cost of Service") },
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Text("How was the service?")

        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            RadioButton(
                selected = optionSelect == "Amazing",
                onClick = { optionSelect = "Amazing"},
            )
            Text("Amazing (20%)")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            RadioButton(
                selected = optionSelect == "Good",
                onClick = { optionSelect = "Good"}
            )
            Text("Good (18%)")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            RadioButton(
                selected = optionSelect == "Okay",
                onClick = { optionSelect = "Okay"}
            )
            Text("Okay (16%)")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Round up tip?")
            Switch(
                checked = switchPosition,
                onCheckedChange = {isChecked -> switchPosition = isChecked}
            )
        }

        Button(
            onClick = {
                if(inputNilai.isEmpty() || inputNilai == "0") {
                    Toast.makeText(context, "Silahkan masukkan angka dan bukan nol!", Toast.LENGTH_SHORT).show()
                    return@Button
                }
                if(inputNilai < "0") {
                    Toast.makeText(context, "jangan masukkan angka negatif!", Toast.LENGTH_SHORT).show()
                    return@Button
                }
                hasil = tipCalculator(inputNilai.toInt(), optionSelect, switchPosition)
                      },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                contentColor = colorResource(R.color.white),
                containerColor = colorResource(R.color.hijau_muda)
            ),
            shape = RoundedCornerShape(5.dp)
            ) { Text("CALCULATE") }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text("Tip Amount: $")
            hasil.let { Text("$it") }
        }
    }
}
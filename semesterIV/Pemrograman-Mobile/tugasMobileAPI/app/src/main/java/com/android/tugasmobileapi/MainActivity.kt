package com.android.tugasmobileapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.android.tugasmobileapi.ui.theme.TugasMobileAPITheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TugasMobileAPITheme {
                MessageScreen()
            }
        }
    }
}

@Composable
fun MessageScreen() {
    var Pesan by remember { mutableStateOf("Loading...") }

    // Panggil API saat composable pertama kali tampil
    LaunchedEffect(Unit) {
        RetrofitClient.instance.getMessage().enqueue(object : Callback<MessageResponse> {
            override fun onResponse(
                call: Call<MessageResponse>,
                response: Response<MessageResponse>
            ) {
                Pesan = if (response.isSuccessful) {
                    response.body()?.Pesan ?: "tidak ada pesan"
                } else {
                    "Error: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<MessageResponse>, t: Throwable) {
                Pesan = "Network error: ${t.message}"
            }
        })
    }
//
//    var Pesan by remember { mutableStateOf("Loading...") }
//    val pesanBaru = MessageRequest("Halo adri andorid!")
//    // Panggil API saat composable pertama kali tampil
//    LaunchedEffect(Unit) {
//        RetrofitClient.instance.sendMessage(pesanBaru).enqueue(object : Callback<void> {
//            override fun onResponse(
//                call: Call<void>,
//                response: Response<void>
//            ) {
//                Pesan = if (response.isSuccessful) {
//                    response.body()?.Pesan ?: "No Pesan"
//                } else {
//                    "Error: ${response.code()}"
//                }
//            }
//
//            override fun onFailure(call: Call<void>, t: Throwable) {
//                Pesan = "Network error: ${t.message}"
//            }
//        })
//    }

    // UI-nya
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = Pesan, style = MaterialTheme.typography.headlineSmall)
    }
}


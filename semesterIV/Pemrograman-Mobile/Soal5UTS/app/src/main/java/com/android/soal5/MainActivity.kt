package com.android.soal5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.text.buildSpannedString
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.soal5.ui.theme.Soal5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            Soal5Theme {
                val navController = rememberNavController()
                Display(navController)
            }
        }
    }
}

@Composable
fun Display(navController: NavHostController) {
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "Main",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("Main") {
                Main(navController)
            }
            composable("detail") {
                Detail()
            }
        }
    }
}

@Composable
fun Main(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(horizontal = 6.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Title("Biodata Mahasiswa")
        Image(
            painter = painterResource(id = R.drawable.jovanimg),
            contentDescription = "",
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .width(250.dp),
        )
        Spacer(modifier = Modifier.height(16.dp))
        biodataList.forEach { item ->
            DataRow(label = item.label, value = item.value)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("detail") },
            shape = RoundedCornerShape(6.dp)
        ) { Text("Detail") }
    }
}

@Composable
fun Detail() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Title("Biografi Mahasiswa")
        Image(
            painter = painterResource(id = R.drawable.jovanimgagain),
            contentDescription = "Gambar Jovan",
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .width(250.dp)
        )
        Column {
            BiografiDesc("Nama saya adalah Jovan Gilbert Natamasindah, lahir di Banjarmasin pada tanggal 17 Juni 2005. Saya merupakan anak pertama dari tiga bersaudara. Semenjak masa Pandemi Covid-19, saya memiliki minat yang besar dalam bidang teknologi dan komputer. Ketertarikan ini membawa saya untuk mengulik seputar teknologi terlebih pada bidang Pengembangan Web. setelah lulus dari SMA, saya memutuskan untuk melanjutkan pendidikan di jurusan Teknologi Informasi Fakultas Teknik di Universitas Lambung Mangkurat.")
            BiografiDesc("Selama menjalani masa perkuliahan, saya aktif mengikuti berbagai kegiatan kampus seperti organisasi mahasiswa yaitu Himpunan Mahasiswa Teknologi Informasi, seminar teknologi, serta beberapa perlombaan pada bidang IT. Salah satu pencapaian yang saya banggakan adalah ketika berhasil menjalankan sebuah workshop Cyber Security pada tahun 2024 silam.")
            BiografiDesc("Saya dikenal sebagai pribadi yang tekun, disiplin, dan senang belajar hal baru. Di waktu luang, saya suka membaca artikel teknologi, bermain game strategi, dan mengembangkan aplikasi kecil-kecilan untuk menambah keterampilan saya.")
            BiografiDesc("Kedepannya, saya bercita-cita ingin menjadi seorang Website Developer yang mampu menciptakan sebuah website yang inovatif untuk memecahkan masalah masyarakat melalui teknologi bidang website.")
        }
        Title("Kepanitiaan yang Pernah Diikuti")
        organizationList.forEach { item ->
            Column {
                Image(
                    painter = painterResource(id = item.Img),
                    contentDescription = item.judul,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(item.judul, fontWeight = FontWeight.SemiBold)
                Text(item.tanggal)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}




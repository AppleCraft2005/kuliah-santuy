package com.android.cobacoba

import android.content.res.Configuration
import android.media.audiofx.AudioEffect.Descriptor
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.android.cobacoba.ui.theme.CobacobaTheme
import com.utsman.osmandcompose.Marker
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import com.utsman.osmandcompose.OpenStreetMap
import com.utsman.osmandcompose.rememberCameraState
import com.utsman.osmandcompose.rememberMarkerState

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        org.osmdroid.config.Configuration.getInstance().load(applicationContext, getSharedPreferences("osmdroid", MODE_PRIVATE))
        org.osmdroid.config.Configuration.getInstance().userAgentValue = packageName
        enableEdgeToEdge()
        setContent {
            CobacobaTheme {
                display()
            }
        }
    }
}

data class MarkerDesc(
    val title: String,
    val snippet: String,
    val geoPoint: GeoPoint
)

val listFireStationCoordinates = listOf(
    MarkerDesc("Seberang Mesjid", "Posko Damkar ", GeoPoint(-3.31987, 114.59075)),
    MarkerDesc("Tanjung Pagar", "Posko Damkar ", GeoPoint(-3.31548, 114.60348))
)

val listFireLocationCoordinates = listOf(
    MarkerDesc("Kebakaran Pelambuan", "Kebakaran", GeoPoint(-3.33, 114.59)),
    MarkerDesc("Kebakaran Teluk Dalam", "Kebakaran", GeoPoint(-3.34, 114.6)),
)
// panggil semua composable untuk MapScreen
@Composable
fun display(modifier: Modifier = Modifier) {
    var selectedTabIndex by remember { mutableStateOf(0) }

    // menentukan daftar marker yang akan ditampilkan berdasarkan selectedTabIndex
    val markersForCurrentTab = if (selectedTabIndex == 0) {
        listFireStationCoordinates // Untuk "Peta Posko"
    } else  {
        listFireLocationCoordinates // Untuk "Peta Kebakaran"
    }

    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TabOption(
                selectedTabIndex = selectedTabIndex,
                tabTitles = listOf("Peta Posko", "Peta Kebakaran"),
                onTabSelected = {newIndex -> selectedTabIndex = newIndex}
            )
            Spacer(modifier = Modifier.height(50.dp))
            UtsmanOsmMapView(markersToDisplay = markersForCurrentTab, key = selectedTabIndex)
            Spacer(modifier = Modifier.height(20.dp))
            Desc(descToDisplay = selectedTabIndex)
        }
    }
}

@Composable
fun TabOption(selectedTabIndex: Int, tabTitles: List<String>, onTabSelected: (Int) -> Unit) {
    Row(horizontalArrangement = Arrangement.Center){
        TabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier.width(300.dp),
            containerColor = Color.Transparent,
            indicator = {tabPositions ->
                Box(
                    Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex])
                        .height(3.dp)
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(topStart = 2.dp, topEnd = 2.dp)
                        )
                )
            }
            ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { onTabSelected(index)},
                    text = {
                        Text(
                            title,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        ) }
                )
            }
        }
    }

}

@Composable
fun UtsmanOsmMapView(markersToDisplay: List<MarkerDesc>, key: Any? = null) {
    // define camera state
    key(key) {
        val cameraState = rememberCameraState {
            geoPoint = GeoPoint(-3.316694, 114.590111)
            zoom = 14.0 // optional, default is 5.0
        }

        val currentMarkerStates = markersToDisplay.map { rememberMarkerState(geoPoint = it.geoPoint) }
        // add node
            Surface(modifier = Modifier
                .width(380.dp)
                .height(500.dp)
            ) {
                OpenStreetMap(
                    modifier = Modifier
                        .fillMaxSize(),
                    cameraState = cameraState
                ) {
                    markersToDisplay.zip(currentMarkerStates).forEach { (posko, markerState) ->
                        Marker(
                            state = markerState,
                            title = posko.title,
                            snippet = posko.snippet
                        ) {
                            // create info window node
                            Column(
                                modifier = Modifier
                                    .width(100.dp)
                                    .background(
                                        color = Color.Black,
                                        shape = RoundedCornerShape(7.dp)
                                    ),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                // setup content of info window
                                Text(text = it.title,color = Color.White)
                                Text(text = it.snippet, fontSize = 10.sp, color = Color.White)
                            }
                        }
                    }
                }
            }

    }
}

@Composable
fun Desc(descToDisplay: Int) {

    var showDesc = if (descToDisplay == 0) {
        "Peta ini akan menampilkan lokasi-lokasi dari posko pemadam kebakaran di daerah Banjarmasin"
    }
    else {
        "Peta ini akan menampilkan lokasi-lokasi dari kebakaran yang terjadi di daerah Banjarmasin"
    }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = showDesc,
            modifier = Modifier.width(380.dp),
            fontSize = 12.sp,
            lineHeight = 18.sp,
            textAlign = TextAlign.Justify
        )
    }
}

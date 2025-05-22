package com.android.cobacoba

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
        setContent {
            CobacobaTheme {
//                native OSM
//                Surface(modifier = Modifier.fillMaxSize()) {
//                    OsmMapView(modifier = Modifier.fillMaxSize())
//                }
//                utsman OSM
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    utsmanOsmMapView()
                }
            }
        }
    }
}
// native OSM
//@Composable
//fun OsmMapView(modifier: Modifier = Modifier) {
//    val context = LocalContext.current
//
//    AndroidView(
//        modifier = modifier,
//        factory = {
//            MapView(context).apply {
//                setTileSource(TileSourceFactory.MAPNIK)
//                setMultiTouchControls(true)
//
//                val bjmCoordinate = GeoPoint(-3.316694, 114.590111)
//
//                val mapController = controller
//                mapController.setZoom(15.0)
//                val startPoint = bjmCoordinate // Jakarta
//                mapController.setCenter(startPoint)
//
//                // Tambahkan marker satu per satu
//                val markers = listOf(
//                    Marker(this).apply {
//                        position = GeoPoint(-3.28, 114.6)
//                        title = "Posko Damkar"
//                        snippet = "Sungai Andai"
//                        setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
//                    },
//                    Marker(this).apply {
//                        position = GeoPoint(-3.3, 114.58)
//                        title = "Posko Damkar"
//                        snippet = "Alalak Selatan"
//                        setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
//                    },
//                    Marker(this).apply {
//                        position = GeoPoint(-3.32, 114.61)
//                        title = "Posko Damkar"
//                        snippet = "Belitung Selatan"
//                        setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
//                    },
//                    Marker(this).apply {
//                        position = GeoPoint(-3.31, 114.62)
//                        title = "Posko Damkar"
//                        snippet = "Kayu Tangi"
//                        setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
//                    },
//                    Marker(this).apply {
//                        position = GeoPoint(-3.34, 114.60)
//                        title = "Posko Damkar"
//                        snippet = "Kuin Selatan"
//                        setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
//                    }
//                )
//
//                markers.forEach { overlays.add(it) }
//
//            }
//        }
//    )
//}

data class poskoDamkar(
    val title: String,
    val snippet: String,
    val geoPoint: GeoPoint
)

val listCoordinate = listOf(
    poskoDamkar("Sungai Andai", "Posko Damkar ", GeoPoint(-3.28, 114.6)),
    poskoDamkar("Alalak Selatan", "Posko Damkar ", GeoPoint(-3.3, 114.58)),
    poskoDamkar("Belitung Selatan", "Posko Damkar ", GeoPoint(-3.32, 114.61)),
    poskoDamkar("Kayu Tangi", "Posko Damkar ", GeoPoint(-3.31, 114.62)),
    poskoDamkar("Pelambuan", "Posko Damkar ", GeoPoint(-3.33, 114.59)),
    poskoDamkar("Kuin Selatan", "Posko Damkar ", GeoPoint(-3.34, 114.6)),
    poskoDamkar("Teluk Dalam", "Posko Damkar ", GeoPoint(-3.35, 114.61)),
    poskoDamkar("Banjarmasin Timur", "Posko Damkar ", GeoPoint(-3.32692, 114.62616)),
    poskoDamkar("Seberang Mesjid", "Posko Damkar ", GeoPoint(-3.31987, 114.59075)),
    poskoDamkar("Tanjung Pagar", "Posko Damkar ", GeoPoint(-3.31548, 114.60348))
)

//utsman OSM
@Composable
fun utsmanOsmMapView() {
    // define camera state
    val cameraState = rememberCameraState {
        geoPoint = GeoPoint(-3.316694, 114.590111)
        zoom = 16.0 // optional, default is 5.0
    }

    val damkarCoordinates = listCoordinate.map { rememberMarkerState(geoPoint = it.geoPoint) }

    // add node
    OpenStreetMap(
        modifier = Modifier.fillMaxSize(),
        cameraState = cameraState
    ) {
        listCoordinate.zip(damkarCoordinates).forEach { (posko, markerState) ->
            Marker(
                state = markerState,
                title = posko.title,
                snippet = posko.snippet
            ) {
                // create info window node
                Column(
                    modifier = Modifier
                        .width(100.dp)
                        .background(color = Color.Black, shape = RoundedCornerShape(7.dp)),
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
package com.android.cobacoba

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.android.cobacoba.ui.theme.CobacobaTheme
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        org.osmdroid.config.Configuration.getInstance().load(applicationContext, getSharedPreferences("osmdroid", MODE_PRIVATE))
        org.osmdroid.config.Configuration.getInstance().userAgentValue = packageName
        setContent {
            CobacobaTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    OsmMapView(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun OsmMapView(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    AndroidView(
        modifier = modifier,
        factory = {
            MapView(context).apply {
                setTileSource(TileSourceFactory.MAPNIK)
                setMultiTouchControls(true)

                val bjmCoordinate = GeoPoint(-3.316694, 114.590111)

                val mapController = controller
                mapController.setZoom(15.0)
                val startPoint = bjmCoordinate // Jakarta
                mapController.setCenter(startPoint)

                // Tambahkan marker satu per satu
                val markers = listOf(
                    Marker(this).apply {
                        position = GeoPoint(-3.28, 114.6)
                        title = "Posko Damkar"
                        snippet = "Sungai Andai"
                        setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                    },
                    Marker(this).apply {
                        position = GeoPoint(-3.3, 114.58)
                        title = "Posko Damkar"
                        snippet = "Alalak Selatan"
                        setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                    },
                    Marker(this).apply {
                        position = GeoPoint(-3.32, 114.61)
                        title = "Posko Damkar"
                        snippet = "Belitung Selatan"
                        setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                    },
                    Marker(this).apply {
                        position = GeoPoint(-3.31, 114.62)
                        title = "Posko Damkar"
                        snippet = "Kayu Tangi"
                        setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                    },
                    Marker(this).apply {
                        position = GeoPoint(-3.34, 114.60)
                        title = "Posko Damkar"
                        snippet = "Kuin Selatan"
                        setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
                    }
                )

                markers.forEach { overlays.add(it) }

            }
        }
    )
}

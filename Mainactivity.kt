import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tomtom.sdk.maps.display.MapView
import com.tomtom.sdk.maps.display.TomTomMap
import com.tomtom.sdk.maps.display.ui.MapOptions
import com.tomtom.sdk.common.location.GeoPoint
import com.tomtom.sdk.maps.display.style.ColorScheme
import com.tomtom.sdk.maps.display.ui.MapType

class MainActivity : AppCompatActivity() {
    private lateinit var mapView: MapView
    private lateinit var tomTomMap: TomTomMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mapView = findViewById(R.id.mapView)
        mapView.initialize(
            apiKey = "YOUR_TOMTOM_API_KEY",
            options = MapOptions(mapType = MapType.STANDARD, colorScheme = ColorScheme.LIGHT)
        ) { map ->
            tomTomMap = map
            tomTomMap.centerOn(GeoPoint(-26.2041, 28.0473), zoom = 10.0) // Example location (Johannesburg)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }
}

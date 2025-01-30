import com.tomtom.sdk.location.Provider
import com.tomtom.sdk.location.provider.DefaultLocationProvider
import com.tomtom.sdk.common.location.GeoPoint

private fun startTracking() {
    val locationProvider: Provider = DefaultLocationProvider(this)
    locationProvider.start { location ->
        val currentLocation = GeoPoint(location.latitude, location.longitude)
        tomTomMap.centerOn(currentLocation, zoom = 15.0)
    }
}

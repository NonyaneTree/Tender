import com.tomtom.sdk.routing.routeplanner.online.OnlineRoutePlanner
import com.tomtom.sdk.routing.routeplanner.RoutePlanningOptions
import com.tomtom.sdk.routing.common.Route
import com.tomtom.sdk.common.location.GeoPoint

private fun calculateRoute(driverLocation: GeoPoint, customerLocation: GeoPoint) {
    val routePlanner = OnlineRoutePlanner.create("YOUR_TOMTOM_API_KEY")
    val options = RoutePlanningOptions(
        origin = driverLocation,
        destination = customerLocation
    )

    routePlanner.planRoute(options) { result ->
        result.fold(
            onSuccess = { routes: List<Route> ->
                val bestRoute = routes.firstOrNull()
                bestRoute?.let { tomTomMap.addRoute(it) }
            },
            onFailure = { error ->
                println("Route planning error: $error")
            }
        )
    }
}

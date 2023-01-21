package com.example.googlemapsdemo.misc

import android.graphics.Color
import com.example.googlemapsdemo.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolygonOptions
import com.google.android.gms.maps.model.PolylineOptions
import kotlinx.coroutines.delay

class MapShapes {

    // Add a marker in Sydney and move the camera
    private val westlandsPosition = LatLng(-1.2673718969605754, 36.81226686858198)
    private val mmustPosition = LatLng(-1.2660835072326522, 36.837240037594015)
    private val archives = LatLng(-1.2849899496958332, 36.82597919288422)
    private val nakuru = LatLng(-0.22972987913780205, 36.05791600918683)
    private val kakamega = LatLng(0.3103618307600136, 34.77220581284084)

    private val p0 = LatLng(-1.2744861137741026, 36.791349322430776)
    private val p1 = LatLng(-1.2791142537498352, 36.869841499971265)
    private val p2 = LatLng(-1.3112024597026435, 36.87457366270635)
    private val p3 = LatLng(-1.322926894420689, 36.79042346450435)

    private val p00 = LatLng(-1.286657136058744, 36.81404080419273)
    private val p01 = LatLng(-1.2869222146258155, 36.827094118574884)
    private val p02 = LatLng(-1.2960572129873222, 36.82813430456471)
    private val p03 = LatLng(-1.2967708833496088, 36.81412238740762)

    //  POLYLINE
    private suspend fun addPolyline(map: GoogleMap) {

        val polyline = map.addPolyline(
            PolylineOptions().apply {
                //  define the exact points/locations
                add(westlandsPosition, archives)
                width(5f)
                color(Color.BLUE)
                geodesic(true)
                clickable(true)
            }
        )

        delay(4000)

        val newPoints = listOf(
            westlandsPosition, nakuru, kakamega
        )

        polyline.points = newPoints

    }

    //  POLYGON
    fun addPolygon(map: GoogleMap) {

        val polygon = map.addPolygon(PolygonOptions().apply {
            add(p0, p1, p2, p3)
            fillColor(R.color.myBlue)
            strokeColor(R.color.myBlue)
            addHole(listOf(p00, p01, p02, p03))
        })
    }

    //  CIRCLE
    suspend fun addCircle(map: GoogleMap) {

        val circle = map.addCircle(CircleOptions().apply {
            center(kakamega)
            radius(50000.0)
            fillColor(R.color.myBlue)
        })

        delay(3000)

        circle.fillColor = R.color.teal_200
    }
}










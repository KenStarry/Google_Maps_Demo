package com.example.googlemapsdemo.misc

import com.example.googlemapsdemo.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.GroundOverlayOptions
import com.google.android.gms.maps.model.LatLng

class Overlays {

    private val westlandsPosition = LatLng(-1.2673718969605754, 36.81226686858198)

    fun addGroundOverlay(map: GoogleMap) {

        val groundOverlay = map.addGroundOverlay(
            GroundOverlayOptions().apply {

                //  width in metres
                position(westlandsPosition, 1000f, 1000f)
                image(BitmapDescriptorFactory.fromResource(R.drawable.baseline_electric_car_24))
            }
        )
    }
}
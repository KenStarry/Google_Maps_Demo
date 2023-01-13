package com.example.googlemapsdemo.misc

import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

class CameraAndViewPort {

    //  define the camera position for our current location
    val pangoPosition: CameraPosition = CameraPosition.Builder()
        .target(LatLng(-1.2660835072326522, 36.837240037594015))
        .zoom(17f)
        .bearing(20f)
        .tilt(45f)
        .build()
}
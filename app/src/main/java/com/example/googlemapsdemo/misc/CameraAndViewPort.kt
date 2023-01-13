package com.example.googlemapsdemo.misc

import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

class CameraAndViewPort {

    //  define the camera position for our current location
    val kakamega: CameraPosition = CameraPosition.Builder()
        .target(LatLng(0.3236950297405758, 34.7479339327619))
        .zoom(17f)
        .bearing(100f)
        .tilt(45f)
        .build()
}
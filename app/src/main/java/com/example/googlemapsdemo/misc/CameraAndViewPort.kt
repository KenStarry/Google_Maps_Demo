package com.example.googlemapsdemo.misc

import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds

class CameraAndViewPort {

    //  define the camera position for our current location
    val westlandsPosition: CameraPosition = CameraPosition.Builder()
        .target(LatLng(-1.2673718969605754, 36.81226686858198))
        .zoom(13f)
        .bearing(20f)
        .tilt(90f)
        .build()

    val mmustBounds = LatLngBounds(
        LatLng(0.28986575782610285, 34.76042407385056), // south west
        LatLng(0.294942202366755, 34.7641785767352) // north east
    )
}
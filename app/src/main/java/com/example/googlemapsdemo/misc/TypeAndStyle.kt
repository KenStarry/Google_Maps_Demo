package com.example.googlemapsdemo.misc

import android.content.Context
import android.util.Log
import android.view.MenuItem
import com.example.googlemapsdemo.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.MapStyleOptions

class TypeAndStyle {

    //  set our map style using our map_style.json raw file
    //  customized from -> https://mapstyle.withgoogle.com/
    fun setMapStyle(googleMap: GoogleMap, context: Context) {

        try {
            //  returns a boolean
            val success = googleMap.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                    context,
                    R.raw.map_style
                )
            )

            if (!success)
                Log.d("Maps", "Failed to add style")

        } catch (e: Exception) {
            Log.d("Maps", "$e")
        }
    }

    fun setMapType(item: MenuItem, map: GoogleMap) {
        when (item.itemId) {
            R.id.normal_map -> {
                //  apply NORMAL maps
                map.mapType = GoogleMap.MAP_TYPE_NORMAL
            }
            R.id.hybrid_map -> {
                //  apply HYBRID maps
                map.mapType = GoogleMap.MAP_TYPE_HYBRID
            }
            R.id.satellite_map -> {
                //  apply SATELLITE maps
                map.mapType = GoogleMap.MAP_TYPE_SATELLITE
            }
            R.id.terrain_map -> {
                //  apply TERRAIN maps
                map.mapType = GoogleMap.MAP_TYPE_TERRAIN
            }
            R.id.none_map -> {
                //  apply NONE maps
                map.mapType = GoogleMap.MAP_TYPE_NONE
            }
        }
    }
}
package com.example.googlemapsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.googlemapsdemo.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.MapStyleOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.map_types_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
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
        return true
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        // Add a marker in Sydney and move the camera
        val kakamega = LatLng(0.3236950297405758, 34.7479339327619)
        map.addMarker(MarkerOptions().position(kakamega).title("Marker in Kakamega"))
//        map.moveCamera(CameraUpdateFactory.newLatLng(kakamega))
        //  the newLatLongZoom accepts two values, the location and zoom value - 1 to 20
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(kakamega, 10f))

        //  modifying map gestures
        map.uiSettings.apply {
            //  enable the pinch to zoom gestures
            isZoomGesturesEnabled = true
            //  enable the zoom controls
            isZoomControlsEnabled = true
            //  enable/disable scroll gestures
            isScrollGesturesEnabled = true
            //  tilt gestures
            isTiltGesturesEnabled = true
            //  rotate gestures
            isRotateGesturesEnabled = true
        }

        //  adding padding
        map.setPadding(0, 0, 20, 0)

        setMapStyle(map)
    }

    //  set our map style using our map_style.json raw file
    //  customized from -> https://mapstyle.withgoogle.com/
    private fun setMapStyle(googleMap: GoogleMap) {

        try {
            //  returns a boolean
            val success = googleMap.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                    this,
                    R.raw.map_style
                )
            )

            if (!success)
                Log.d("Maps", "Failed to add style")
        } catch (e: Exception) {
            Log.d("Maps", "$e")
        }
    }
}









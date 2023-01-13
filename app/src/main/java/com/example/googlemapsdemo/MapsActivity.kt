package com.example.googlemapsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.lifecycleScope

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.googlemapsdemo.databinding.ActivityMapsBinding
import com.example.googlemapsdemo.misc.CameraAndViewPort
import com.example.googlemapsdemo.misc.TypeAndStyle
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private val typeAndStyle by lazy { TypeAndStyle() }
    private val cameraAndViewPort by lazy { CameraAndViewPort() }

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
        typeAndStyle.setMapType(item, map)
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
        val pango = LatLng(-1.2660835072326522, 36.837240037594015)
        val archives = LatLng(-1.2849899496958332, 36.82597919288422)

        map.addMarker(MarkerOptions().position(pango).title("Marker in Kakamega"))
//        map.moveCamera(CameraUpdateFactory.newLatLng(kakamega))
        //  the newLatLongZoom accepts two values, the location and zoom value - 1 to 20
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(kakamega, 10f))

        //  our own custom camera position
        map.moveCamera(CameraUpdateFactory.newCameraPosition(cameraAndViewPort.pangoPosition))

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

        typeAndStyle.setMapStyle(map, this)

        //  change default zoom levels
//        map.setMinZoomPreference(15f)
//        map.setMaxZoomPreference(17f)

        //  set zoom preference programmatically
//        lifecycleScope.launch {
//            delay(5000L)
////            map.moveCamera(CameraUpdateFactory.zoomBy(3f))
//            map.moveCamera(CameraUpdateFactory.zoomTo(18f))
//        }

        //  updating camera position and scrolling to the desired point
        lifecycleScope.launch {
            delay(4000L)
            //  scroll to a certain position
//            map.moveCamera(CameraUpdateFactory.scrollBy(100f, 0f))

            //  create a latLong boundary
//            map.moveCamera(CameraUpdateFactory.newLatLngZoom(cameraAndViewPort.mmustBounds.center, 10f))

            //  creating bounds
            map.moveCamera(CameraUpdateFactory.newLatLngBounds(cameraAndViewPort.mmustBounds, 100))

            //  restrict user movement after setting bounds
            map.setLatLngBoundsForCameraTarget(cameraAndViewPort.mmustBounds)
        }
    }
}









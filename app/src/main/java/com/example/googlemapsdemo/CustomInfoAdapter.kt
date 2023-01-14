package com.example.googlemapsdemo

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.TextView
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
import com.google.android.gms.maps.model.Marker

class CustomInfoAdapter(
    val context: Context
) : InfoWindowAdapter {

    private val contentView = (context as Activity).layoutInflater.inflate(R.layout.custom_info_window, null)

    //  this function will be executed is getInfoWindow returns null
    override fun getInfoContents(marker: Marker): View? {
        renderViews(marker, contentView)
        return contentView
    }

    override fun getInfoWindow(marker: Marker): View? {
        renderViews(marker, contentView)
        return contentView
    }

    private fun renderViews(marker: Marker?, contentView: View) {
        val title = marker?.title ?: ""
        val desc = marker?.snippet ?: ""

        val titleTextView: TextView = contentView.findViewById(R.id.titleTextView)
        titleTextView.text = title

        val descTextView: TextView = contentView.findViewById(R.id.descTextView)
        descTextView.text = desc
    }
}
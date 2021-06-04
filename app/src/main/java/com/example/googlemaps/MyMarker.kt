package com.example.googlemaps

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MyMarker(private val context: Context) {


    fun getMarker(latLong:LatLng,title:String,idImage: Int,descripcion:String):MarkerOptions{
        return MarkerOptions()
                .position(latLong)
                .title(title)
                .icon(setIcon(idImage))
                .snippet(descripcion)
    }

    private fun setIcon(idImage:Int): BitmapDescriptor {
        val heigth=60
        val width=60
        val drawable = ContextCompat.getDrawable(context,idImage) as BitmapDrawable
        val bitmap=drawable.bitmap
        val smallBitMap= Bitmap.createScaledBitmap(bitmap,width,heigth,false)
        return BitmapDescriptorFactory.fromBitmap(smallBitMap)
    }

}
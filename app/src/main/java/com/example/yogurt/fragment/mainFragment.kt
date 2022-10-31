package com.example.yogurt.fragment

import android.Manifest
import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.*
import android.os.Build
import android.os.Bundle
import android.util.Base64.*
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.yogurt.AppData
import com.example.yogurt.AppData.latitude
import com.example.yogurt.MainActivity
import com.example.yogurt.MyFragment
import com.example.yogurt.R
import com.example.yogurt.databinding.ActivityMainBinding
import com.example.yogurt.model.Main_view_model
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.kakao.util.maps.helper.Utility
import kotlinx.android.synthetic.main.activity_main.view.*
import net.daum.android.map.MapViewEventListener
import net.daum.mf.map.api.MapCurrentLocationMarker
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView
import java.io.IOException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*


class mainFragment() : MyFragment(), MapViewEventListener, MapView.POIItemEventListener,LocationListener{

    var mapView: MapView? = null
    var serialThread: Serialthread? = null
    var init = false
    override fun getTitle(): String {
        return ""
    }

    override fun Refresh() {
        AppData.fragment_num = 1
        Log.d("Refresh : ","작동")
        serialThread = Serialthread()
        serialThread?.isDaemon = true
        serialThread?.start()
        serialThread!!.name = "PingThread"
    }

    override fun Exit() {

    }

    var viewModel: Main_view_model? = null
    var mBinding: ActivityMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.activity_main, container, false)
        viewModel = ViewModelProvider(this)[Main_view_model::class.java]
        mBinding!!.mainviewmodel = viewModel
        mBinding!!.lifecycleOwner = this
        mapView = MapView(requireActivity())
        mBinding!!.mapView?.addView(mapView)
        map_update()
        // 줌 레벨 변경
        mapView!!.setZoomLevel(1, true);
// 줌 인
        mapView!!.zoomIn(true);
// 줌 아웃
        mapView!!.zoomOut(true);
        init = true
        return mBinding!!.root
    }
    fun map_update() {
        mapView?.removeAllPOIItems()

        mapView!!.setMapViewEventListener(this); // this에 MapView.MapViewEventListener 구현.

        // 중심점 변경
        mapView!!.setPOIItemEventListener(this);

        var marker = MapPOIItem();
        marker.setItemName("Default Marker");
        marker.setTag(0);
        marker.setMarkerType(MapPOIItem.MarkerType.CustomImage)
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        marker.mapPoint = MapPoint.mapPointWithGeoCoord(AppData.latitude, AppData.longitude)
        mapView!!.addPOIItem(marker);
        mapView!!.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(AppData.latitude, AppData.longitude), true);
    }
    override fun onLoadMapView() {

    }

    override fun onPOIItemSelected(p0: MapView?, p1: MapPOIItem?) {

    }

    override fun onCalloutBalloonOfPOIItemTouched(p0: MapView?, p1: MapPOIItem?) {
    }

    override fun onCalloutBalloonOfPOIItemTouched(
        p0: MapView?,
        p1: MapPOIItem?,
        p2: MapPOIItem.CalloutBalloonButtonType?
    ) {

    }

    override fun onDraggablePOIItemMoved(p0: MapView?, p1: MapPOIItem?, p2: MapPoint?) {

    }

    override fun onLocationChanged(location: Location) {
        Log.d("latidute : ","${location.latitude}")
        Log.d("longtitude : ","${location.longitude}")
                                                           AppData.latitude = location.latitude
        AppData.longitude = location.longitude
        mapView!!.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(AppData.latitude, AppData.longitude), true);
    }
    inner class Serialthread() : Thread() ,MapViewEventListener, MapView.POIItemEventListener,LocationListener{

        override fun run() {
            try {

                while (true) {
                    if (init) {
                        map_update()
                        sleep(10)
                    }
                }
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        }

        override fun onLoadMapView() {
        }

        override fun onPOIItemSelected(p0: MapView?, p1: MapPOIItem?) {
        }

        override fun onCalloutBalloonOfPOIItemTouched(p0: MapView?, p1: MapPOIItem?) {
        }

        override fun onCalloutBalloonOfPOIItemTouched(
            p0: MapView?,
            p1: MapPOIItem?,
            p2: MapPOIItem.CalloutBalloonButtonType?
        ) {
        }

        override fun onDraggablePOIItemMoved(p0: MapView?, p1: MapPOIItem?, p2: MapPoint?) {
        }

        override fun onLocationChanged(p0: Location) {
        }

    }
}
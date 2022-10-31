package com.example.yogurt

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Context
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.media.tv.TvContract.Programs.Genres.encode
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Base64
import android.util.Base64.encode
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.yogurt.AppData.latitude
import com.example.yogurt.AppData.longitude
import com.example.yogurt.databinding.ActivityMainBinding
import com.example.yogurt.fragment.analogFragment
import com.example.yogurt.fragment.mainFragment
import com.example.yogurt.fragment.system_framgment
import com.example.yogurt.model.Analog_ViewModel
import com.google.android.gms.location.*
import java.io.IOException
import java.net.URLEncoder.encode
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity(),
    androidx.fragment.app.FragmentManager.OnBackStackChangedListener{
    var serialThread: Serialthread? = null
    companion object {
        lateinit var viewModel: Analog_ViewModel
        lateinit var mBinding: ActivityMainBinding
        lateinit var mFragmentManager: FragmentManager

        fun fragment_reset(fragment: MyFragment) {


            mFragmentManager.beginTransaction().replace(R.id.main_layout, fragment).commit()
            fragment.Refresh()
        }
    }

        @RequiresApi(Build.VERSION_CODES.P)
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val transaction = supportFragmentManager.beginTransaction()
            try {
                val information =
                    packageManager.getPackageInfo(
                        packageName,
                        PackageManager.GET_SIGNING_CERTIFICATES
                    )
                val signatures = information.signingInfo.apkContentsSigners
                val md = MessageDigest.getInstance("SHA")
                for (signature in signatures) {
                    val md: MessageDigest
                    md = MessageDigest.getInstance("SHA")
                    md.update(signature.toByteArray())
                    var hashcode = String(Base64.encode(md.digest(), 0))
                    Log.d("hashcode", "" + hashcode)
                }
            } catch (e: Exception) {
                Log.d("hashcode", "에러::" + e.toString())

            }
            replace_fragment(mainFragment())

            gps_update()
//            serialThread = Serialthread(Activity())
//            serialThread?.isDaemon = true
//            serialThread?.start()
//            serialThread!!.name = "TestAnalogSerial"


            Log.d("wedo : ", "${AppData.longitude_st}")
            Log.d("gyeongdo : ", "${AppData.latitude_st}")
            Log.d("asd123 : ", "asd123")
            mFragmentManager = supportFragmentManager
        }
    fun gps_update() {
        val lm = getSystemService(LOCATION_SERVICE) as LocationManager
        val isGPSEnabled: Boolean = lm.isProviderEnabled(LocationManager.GPS_PROVIDER)
        val isNetworkEnabled: Boolean = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
        if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this@MainActivity, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),0)
        } else {
            when {
                isNetworkEnabled -> {
                    val location = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                    AppData.longitude = location?.longitude!!
                    AppData.latitude = location.latitude
                    Log.d("longgitude : ","${location?.longitude!!}")
                    Log.d("latitude : ","${location.latitude}")
                }
                isGPSEnabled -> {
                    val location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                    AppData.longitude = location?.longitude!!
                    AppData.latitude = location.latitude
                    Log.d("longgitude : ","${location?.longitude!!}")
                    Log.d("latitude : ","${location.latitude}")
                } else -> {

            }
            }
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,100,0.1F,gpsLocationListener)
            lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,100,0.1F,gpsLocationListener)
        }

    }
    val gpsLocationListener = object  : LocationListener {
        override fun onLocationChanged(p0: Location) {
            val provider: String = p0.provider
            AppData.latitude = p0.latitude
            AppData.longitude = p0.longitude
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
        }
        override fun onProviderDisabled(provider: String) {
        }
        override fun onProviderEnabled(provider: String) {
        }
    }
        inner class Serialthread(val activity: Activity) : Thread() {

            override fun run() {
                try {

                    while (true) {
//                        gps_update()
                        Log.d("wedo : ", "${AppData.longitude_st}")
                        Log.d("gyeongdo : ", "${AppData.latitude_st}")

                        sleep(50)
                    }
                } catch (e: java.lang.Exception) {

                }
            }

        }

        override fun onBackPressed() {
            if (AppData.fragment_num == 2) {
                fragment_reset(mainFragment())
            } else if (AppData.fragment_num == 3) {
                fragment_reset(system_framgment())
            } else if (AppData.fragment_num == 4) {
                fragment_reset(analogFragment())
            }
        }

        fun replace_fragment(fragment: MyFragment) {
            val transaction = supportFragmentManager.beginTransaction()

            transaction.replace(R.id.main_layout, fragment)
            transaction.commit()
            fragment.Refresh()
        }


        override fun onBackStackChanged() {
        }
    }
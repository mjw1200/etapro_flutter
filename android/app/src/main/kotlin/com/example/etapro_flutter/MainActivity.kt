package com.example.etapro_flutter

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.IntentFilter
import android.location.Location
import android.os.BatteryManager
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES

import com.google.android.gms.location.LocationServices
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {
    private val CHANNEL = "native_gps"
    // private val fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler {
                call, result ->

                val lat: Double = 1.23
                val lon: Double = 4.56
                result.success(doubleArrayOf(lat, lon))
                // result.success(arrayOf(1.23, 4.56))

//             if (call.method == "getBatteryLevel") {
//                 val batteryLevel = getBatteryLevel()

//                 if (batteryLevel != -1) {
//                     result.success(batteryLevel)
//                 } else {
//                     result.error("UNAVAILABLE", "Battery level not available.", null)
//                 }
//             } else if (call.method == "getCurrentLocation") {
//                 try {
//                     fusedLocationClient.lastLocation
//                         .addOnSuccessListener { location: Location? ->
//                             result.success(arrayOf(2.1, 7.9))
// //                            result.success(arrayOf(location!!.latitude, location.longitude))
//                         }
//                 }
//                 catch (e: SecurityException) {
//                     result.error("PERMISSION", "Location permissions unavailable", null)
//               }
//             } else {
//                 result.notImplemented()
//             }
        }
    }

//    private fun getBatteryLevel(): Int {
//        val batteryLevel: Int
//        if (VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP) {
//            val batteryManager = getSystemService(Context.BATTERY_SERVICE) as BatteryManager
//            batteryLevel = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
//        } else {
//            val intent = ContextWrapper(applicationContext).registerReceiver(null, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
//            batteryLevel = intent!!.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) * 100 / intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
//        }
//
//        return batteryLevel
//    }
}
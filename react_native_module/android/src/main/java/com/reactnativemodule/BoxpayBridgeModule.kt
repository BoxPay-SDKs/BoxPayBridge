package com.reactnativemodule

import android.content.pm.PackageManager
import com.facebook.react.bridge.*

class BoxpayBridgeModule(reactContext: ReactApplicationContext) :
    ReactContextBaseJavaModule(reactContext) {

  companion object {
    const val NAME = "BoxPayBridge"
  }

  override fun getName(): String = "BoxpayBridge"

    @ReactMethod
    fun getInstalledUpiApps(promise: Promise) {
        val pm = reactApplicationContext.packageManager
        val apps = mutableListOf<String>()

        try {
            val upiApps = listOf("com.google.android.apps.nbu.paisa.user", "net.one97.paytm", "com.phonepe.app")
            for (pkg in upiApps) {
                try {
                    pm.getPackageInfo(pkg, 0)
                    apps.add(pkg)
                } catch (e: Exception) {
                    // App not found
                }
            }
            promise.resolve(Arguments.fromList(apps))
        } catch (e: Exception) {
            promise.reject("UPI_ERROR", "Failed to fetch UPI apps", e)
        }
    }
}

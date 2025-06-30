package com.boxpaybridge.android

import android.content.Context
import android.content.pm.PackageManager
import com.boxpaybridge.shared.UPIAppDetector

class UPIAppDetectorAndroid(private val context: Context) : UPIAppDetector {

    private val upiPackages = listOf(
        "com.google.android.apps.nbu.paisa.user", // GPay
        "net.one97.paytm",                        // Paytm
        "com.phonepe.app"                         // PhonePe
    )

    override fun getInstalledUPIApps(): List<String> {
        val pm = context.packageManager
        return upiPackages.filter { pkg ->
            try {
                pm.getPackageInfo(pkg, PackageManager.GET_ACTIVITIES)
                true
            } catch (e: PackageManager.NameNotFoundException) {
                false
            }
        }
    }
}

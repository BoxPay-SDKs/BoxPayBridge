package com.boxpaybridge.ios

import com.boxpaybridge.shared.UPIAppDetector
import platform.Foundation.NSURL
import platform.UIKit.UIApplication

class UPIAppDetectorIOS : UPIAppDetector {
    private val upiSchemes = mapOf(
        "gpay" to "gpay://",
        "phonepe" to "phonepe://",
        "paytm" to "paytmmp://"
    )

    override fun getInstalledUPIApps(): List<String> {
        return upiSchemes.filter { (_, url) ->
            val nsUrl = NSURL.URLWithString(url)
            UIApplication.sharedApplication.canOpenURL(nsUrl!!)
        }.keys.toList()
    }
}

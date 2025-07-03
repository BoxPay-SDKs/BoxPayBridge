package com.crossplatform.sdk

import com.crossplatform.sdk.UPIAppDetector

class UPIService(private val detector: UPIAppDetector) {
    fun getAvailableApps(): List<String> = detector.getInstalledUPIApps()
}

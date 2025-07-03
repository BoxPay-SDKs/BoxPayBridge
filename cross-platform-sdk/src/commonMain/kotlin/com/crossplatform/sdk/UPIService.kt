package com.boxpaybridge.sdk

class UPIService(private val detector: UPIAppDetector) {
    fun getAvailableApps(): List<String> = detector.getInstalledUPIApps()
}

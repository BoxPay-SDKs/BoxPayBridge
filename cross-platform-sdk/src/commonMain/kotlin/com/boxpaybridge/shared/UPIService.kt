package com.boxpaybridge.shared

class UPIService(private val detector: UPIAppDetector) {
    fun getAvailableApps(): List<String> = detector.getInstalledUPIApps()
}

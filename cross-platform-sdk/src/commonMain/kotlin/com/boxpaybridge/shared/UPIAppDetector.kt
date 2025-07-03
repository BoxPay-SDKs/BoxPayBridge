package com.boxpaybridge.shared

interface UPIAppDetector {
    fun getInstalledUPIApps(): List<String>
}

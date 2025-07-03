package com.boxpaybridge.sdk

interface UPIAppDetector {
    fun getInstalledUPIApps(): List<String>
}

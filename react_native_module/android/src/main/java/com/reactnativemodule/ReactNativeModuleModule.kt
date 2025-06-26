package com.reactnativemodule

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise
import com.boxpaybridge.shared.Greeting // 👈 Import your KMM class

class ReactNativeModuleModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  companion object {
    const val NAME = "BoxPayBridge"
  }

  override fun getName(): String = NAME

  @ReactMethod
  fun greet(promise: Promise) {
    try {
      val greeting = Greeting().greet() // 👈 From your shared KMM class
      promise.resolve(greeting)
    } catch (e: Exception) {
      promise.reject("GREETING_ERROR", e.message, e)
    }
  }
}

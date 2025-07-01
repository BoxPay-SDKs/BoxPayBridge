import Foundation
import boxpaybridge // name must match your XCFramework module name
import React

@objc(BoxpayBridge)
class UPIAppDetector: NSObject {

  @objc
  func getInstalledUpiApps(_ resolve: @escaping RCTPromiseResolveBlock,
                           rejecter reject: @escaping RCTPromiseRejectBlock) {
    let apps = ["com.google.pay", "net.one97.paytm", "com.phonepe.app"] // or call your KMM function here
    resolve(apps)
  }

  @objc
  static func requiresMainQueueSetup() -> Bool {
    return false
  }
}

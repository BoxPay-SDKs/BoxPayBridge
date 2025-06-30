import Flutter
import UIKit

public class FlutterPlugin: NSObject, FlutterPlugin {
    public static func register(with registrar: FlutterPluginRegistrar) {
        let channel = FlutterMethodChannel(name: "boxpay_bridge", binaryMessenger: registrar.messenger())
        let instance = FlutterPlugin()
        registrar.addMethodCallDelegate(instance, channel: channel)
    }

    public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
        switch call.method {
        case "getInstalledUpiApps":
            let apps = BoxPayBridge.getInstalledUpiApps() // ✅ call from xcframework
            result(apps)
        default:
            result(FlutterMethodNotImplemented)
        }
    }
}

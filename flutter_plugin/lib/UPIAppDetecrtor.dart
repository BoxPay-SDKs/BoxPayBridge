import 'package:flutter/services.dart';

class UPIAppDetector {
  static const MethodChannel _channel = MethodChannel('boxpay_bridge');

  static Future<List<String>> getInstalledUpiApps() async {
    final List<dynamic> result = await _channel.invokeMethod('getInstalledUpiApps');
    return result.cast<String>();
  }
}

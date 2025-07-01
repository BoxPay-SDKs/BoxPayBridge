#import <React/RCTBridgeModule.h>
#import "ReactNativeModule.h"
@import boxpaybridge; // ✅ Import the XCFramework module


@implementation ReactNativeModule

RCT_EXPORT_MODULE(BoxpayBridge)

RCT_EXPORT_METHOD(getInstalledUpiApps:(RCTPromiseResolveBlock)resolve
        rejecter:(RCTPromiseRejectBlock)reject)
{
    // Example static response (replace with KMM method call if exposed)
    NSArray *installedApps = @[@"com.phonepe.app", @"net.one97.paytm"];
    resolve(installedApps);
}

@end

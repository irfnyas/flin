import UIKit
import Flutter
import shared

@UIApplicationMain
@objc class AppDelegate: FlutterAppDelegate {
   override func application(
        _ application: UIApplication,
        didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?
    ) -> Bool {
        let controller : FlutterViewController = window?.rootViewController as! FlutterViewController
        let channel = FlutterMethodChannel.init(name: "/sdk", binaryMessenger: controller.binaryMessenger)
        
        channel.setMethodCallHandler({
            (call: FlutterMethodCall, result: @escaping FlutterResult) -> Void in
            SdkKt.processMethodChannel(
                method: call.method ,
                params: call.arguments ?? [:],
                success: {
                    s in result(s)
                },
                error: {
                    _, _, _ in result(FlutterMethodNotImplemented)
                })
        });
        
        GeneratedPluginRegistrant.register(with: self)
        return super.application(application, didFinishLaunchingWithOptions: launchOptions)
    }
}
